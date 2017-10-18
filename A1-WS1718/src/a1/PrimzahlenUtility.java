package a1;

import java.util.Arrays;

public class PrimzahlenUtility {


	/*
	 * statische Methode Teil B-1
	 */
    public static boolean istPrimzahl(int zahl) {
        boolean result = true;
        for (int i = 2; i <= zahl / 2; i++) {
            if (zahl % i == 0) {
                result = false;
            }
        }
        return result;
    }
	
	/*
	 * statische Methode Teil B-2
	 */
	public static int[] generierePrimzahlen(int bis){
	    int[] result = new int[bis];
	    int i = 0, prime = 2;
            while (prime <= bis) {
                if (istPrimzahl(prime)) {
                    result[i] = prime;
                    i++; prime++;
                } else prime++;
            }
        return result;
    }

	
	/*
	 * statische Methode -Teil D
	 */

}
