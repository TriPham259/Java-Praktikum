package a1;

import java.util.Locale;
import java.util.Scanner;

public class BaseTypeUtility {

	// statische Methoden getTypeName
	public static String getTypeName(String token) {
		Scanner sc = new Scanner(token);
		// change locale to English so that decimal mark is ".", not "," (if locale is e.g. German)
		sc.useLocale(Locale.ENGLISH);

		// handle special case when double is regconized as float
		double d = sc.nextDouble();
		float f = (float)d;
		
		// reset scanner
		sc = new Scanner(token);
		sc.useLocale(Locale.ENGLISH);
		
		return sc.hasNextByte() ? "byte"
				: sc.hasNextShort() ? "short"
						: sc.hasNextInt() ? "int"
								: sc.hasNextLong() ? "long"
										// handle special case
										: sc.hasNextFloat() && Double.compare(d, f) >= 0 ? "float"  
												: sc.hasNextDouble() ? "double" : "unknown type";
	}

	// statische Methoden isDouble etc.
	public static boolean isByte(String token) {
		Double aDouble = Double.valueOf(token);
		return aDouble.byteValue() == aDouble;
	}

	public static boolean isShort(String token) {
		Double aDouble = Double.valueOf(token);
		return aDouble.shortValue() == aDouble;
	}

	public static boolean isDouble(String token) {
		Double aDouble = Double.valueOf(token);
		return true;
	}
}