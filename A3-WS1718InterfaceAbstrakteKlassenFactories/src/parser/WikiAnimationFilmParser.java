package parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import interfaces.FilmInterface;
import interfaces.FilmParserInterface;

public class WikiAnimationFilmParser implements FilmParserInterface {

	private Scanner animationScanner;

	/**
	 * Top-Level Methode, die die Datei mit Hilfe eines Scanners parsed und den
	 * Inhalt in eine Liste von AnimationFilm-Objekten überführt.
	 * 
	 * @return Liste von AnimationFilm-Objekten
	 * @throws ParseException
	 *             Tritt u.a. auf, wenn beim Parsen von Date Objekten ein Fehler
	 *             erzeugt wird.
	 */
	public List<FilmInterface> contentToFilmList() throws ParseException {
		//TODO
		return null;
	}

	/**
	 * Gegeben
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
