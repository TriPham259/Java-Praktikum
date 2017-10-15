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
	    for (int i = 0; i <= bis;) {
            for (int j =2; j <= bis;) {
                if (istPrimzahl(i)) {
                    result[i] = j;
                    i++;
                } else j++;
            }
        }
    }

	
	/*
	 * statische Methode -Teil D
	 */

}
