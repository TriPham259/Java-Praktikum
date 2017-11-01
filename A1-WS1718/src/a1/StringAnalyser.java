package a1;

public class StringAnalyser {

	// main Methode
	public static void main(String[] args) {
		analyseChars(args[0]);
		// type to command line to run e.g.
		// java -cp D:\GitHub\PM2\A1-WS1718\bin a1.StringAnalyser "hello cruel world 123"
	}

	// statische Methode analyseChars
	public static void analyseChars(String token) {
		char[] cAry = token.toCharArray();
		int digits = 0, alpha = 0, lowerAlpha = 0, upperAlpha = 0, spaces = 0;
		for (char c : cAry) {
			if (Character.isDigit(c)) {
				digits++;
				continue;
			}
			if (Character.isLetter(c)) {
				alpha++;
			}
			if (Character.isLowerCase(c)) {
				lowerAlpha++;
				continue;
			}
			if (Character.isUpperCase(c)) {
				upperAlpha++;
				continue;
			}
			if (Character.isWhitespace(c)) {
				spaces++;
				continue;
			}
		}
		System.out.println("Ergebnis:\nZiffern:" + digits + "\nBuchstaben:" + alpha + "\nKleinbuchstaben:" + lowerAlpha
				+ "\nGroßbuchstaben:" + upperAlpha + "\nGroßbuchstaben:" + spaces);
	}

	/*
	 * Satz "die ist ein 1'ter Test und ein 2'ter folgt um 15 30" Ergebnis:
	 * Ziffern:6 Buchstaben:32 Kleinbuchstaben:31 Großbuchstaben:1 Leerzeichen:11
	 */

}