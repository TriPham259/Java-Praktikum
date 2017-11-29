package parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.AnimationFilm;

public class WikiAnimationFilmParser {
	private Scanner animationScanner;
	// find the start of the table 
//	private Pattern regexBegin = Pattern.compile("<h2><span id=\"1995-2004\">.*?</h2>");
	
	// find the start of a year 
	private Pattern regexYearBegin = Pattern.compile("<td colspan=\"6\".*?>");
	
	// find the year's number (1) and its content (2)
	private Pattern regexYear = Pattern.compile(".*?<a href=.*?>(.*?)</a>(.*)", 
			Pattern.MULTILINE | Pattern.DOTALL);
	
	// find a film's content (1)
	private Pattern regexFilm = Pattern.compile("<tr>(.*?)</tr>", 
			Pattern.MULTILINE | Pattern.DOTALL);
	
	// find the data in a film's content
	private Pattern regexFilmData = Pattern.compile(
			".*?<td>(.*?)</td>.*?"		// date 				(1)
			+ "<td>(.*?)</td>.*?"		// list of countries 	(2)
			+ "<td>(.*?)</td>.*?"		// german title 		(3)
			+ "<td>(.*?)</td>.*?"		// original title 		(4)
			+ "<td>(.*?)</td>.*?"		// list of studios 		(5)
			+ "(<td>(.*?)</td>)?.*?", 	// comment (optional)	(6)
			Pattern.MULTILINE | Pattern.DOTALL);

	// print the whole HTML page
	public void echoPage() throws ParseException {
		while (animationScanner.hasNextLine()) {
			System.out.println(animationScanner.nextLine());
		}
	}

	/**
	 * Top-Level Methode, die die Datei mit Hilfe eines Scanners parsed und den
	 * Inhalt in eine Liste von AnimationFilm-Objekten überführt.
	 * 
	 * @return Liste von AnimationFilm-Objekten
	 * @throws ParseException
	 *             Tritt u.a. auf, wenn beim Parsen von Date Objekten ein Fehler
	 *             erzeugt wird.
	 */
	public List<AnimationFilm> contentToFilmList() throws ParseException {
//		animationScanner.useDelimiter(regexBegin);
		// create an ArrayList for result 
		ArrayList<AnimationFilm> listeFilme = new ArrayList<>();
		
		// use start of a year as the delimiter
		animationScanner.useDelimiter(regexYearBegin);
		
		while (animationScanner.hasNext()) {
			// get a year's content 
			String yearString = animationScanner.next();
			
			// find the year's number (1) and its content (2)
			Matcher matcherYear = regexYear.matcher(yearString);
			
			if (matcherYear.find()) {
				// get the year number 
				String filmYear = clean(matcherYear.group(1));
				
				// get the year's content 
				String contentYear = matcherYear.group(2);
				
				// find films's content in year's content 
				Matcher matcherContentYear = regexFilm.matcher(contentYear);
				
				while (matcherContentYear.find()) {
					// get a film's content in year's content
					String contentFilm = matcherContentYear.group(1);
					
					// find the data in film's content 
					Matcher matcherContentFilm = regexFilmData.matcher(contentFilm);
					
					if (matcherContentFilm.matches()) {
						// get the film's data
						Date date = parseDate(clean(matcherContentFilm.group(1)), filmYear);
						List<String> countries = stringToArrayList(clean(matcherContentFilm.group(2)));
						String germanTitle = clean(matcherContentFilm.group(3));
						String originalTitle = clean(matcherContentFilm.group(4));
						List<String> studios = stringToArrayList(clean(matcherContentFilm.group(5)));
						
						// fill comment with empty string if it doesn't exist
						String group6 = matcherContentFilm.group(6);
						String comment = (group6 != null) ? clean(group6) : "";
						
						// create a film object
						AnimationFilm oneFilm = new AnimationFilm(originalTitle, germanTitle, date,
								countries, studios, comment);
						
						// add film to the ArrayList
						listeFilme.add(oneFilm);
					}
				}
			}
		}
		return listeFilme;
	}

	// split String to Array and convert it to ArrayList
	private List<String> stringToArrayList(String str) {
		return new ArrayList<String>(Arrays.asList(str.split("\\s*,\\s*")));
	}

	/**
	 * Löscht alle HTML-Tags aus der Zeichenkette und ersetzt HTML Sonderzeichen
	 * (z.B. &amp;) durch lesbare Zeichen
	 * 
	 * @param str:
	 *            Zeichenkette, die noch HTML Tags oder HTML Sonderzeichen
	 *            enthält
	 * @return Zeichenkette ohne HTML-Tags und mit lesbaren Varianten für die
	 *         Sonderzeichen
	 */
	// remove HTML tags and replace HTML special characters
	private String clean(String str) { 
		return str.replaceAll("<a.*?>|</a>|<b>|</b>|<i>|</i>|<p>|</p>|<small>|</small>|" 
				+ "<span.*?>|</span>|\\r|\\n|", "").replaceAll("<br>", " ").replaceAll("&amp", "&");
	}

	/**
	 * Erzeugt aus einer Zeichenkette, die Tag und Monatsangaben enthält, und
	 * einer Zeichenkette, die die Jahreszahl enthält, ein Datumsobjekt.
	 * 
	 * @param dayAndMonth
	 *            Zeichenkette, die Tag und Monatsangaben enthält. Zeichenkette
	 *            ist ggf. nicht konform zur Darstellung von deutschen Tag und
	 *            Monatsangaben in der Langform und muss daher hier in eine
	 *            gültige Form überführt werden.
	 * @param year
	 *            Zeichenkette, die die Jahresangabe als 4-stellige Ziffer
	 *            enthält. Zeichenkette ist ggf. nicht konform zur Darstellung
	 *            von 4-stelligen Jahresangaben und muss daher hier in eine
	 *            gültige Form überführt werden.
	 * @return Date - Objekt für die Datumsangaben in dayAndMonth und year
	 * @throws ParseException
	 */
	private Date parseDate(String dayAndMonth, String year) throws ParseException {
		// find day (1) and month (2) in string 
		Pattern regexDate = Pattern.compile(".*?([0-9]{1,2}).*?"
				+ "(Januar|Februar|März|April|Mai|Juni|"
				+ "Juli|August|September|Oktober|November|Dezember).*?");
		
		Matcher matcherDate = regexDate.matcher(dayAndMonth);
		
		while (matcherDate.find()) {
			String date = matcherDate.group(1) + ". " + matcherDate.group(2);
			Date parsedDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY)
					.parse(String.format("%s %s", date, year));
			return parsedDate;
		}
		
		return null;
	}

	/**
	 * GEGEBEN
	 * 
	 * @param url
	 *            Zeichenkette, die die URL-Ressource korrekt beschreibt
	 * @throws MalformedURLException
	 *             URL im falschen Format
	 * @throws IOException
	 *             kein Zugriff auf die Ressource
	 */
	public WikiAnimationFilmParser(String url) throws MalformedURLException, IOException {
		this.animationScanner = new Scanner(new URL(url).openStream(), "UTF-8");
	}
}