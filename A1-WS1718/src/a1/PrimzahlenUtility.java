package a1;

import java.util.Arrays;

public class PrimzahlenUtility {

	/*
	 * statische Methode Teil B-1
	 */
	public static boolean istPrimzahl(int zahl) {
		for (int i = 2; i <= zahl/2; i++)
			if (zahl % i == 0) 
				return false;
		return true;
	}
	
	/*
	 * statische Methode Teil B-2
	 */
	public static int[] generierePrimZahlen(int bis) {
		int[] primeAry = new int[bis];
		int cursor = 0;  	
		for (int prime = 2; prime <= bis; prime++) {
			if (istPrimzahl(prime)) {
				// save prime number to p and move cursor forward
				primeAry[cursor++] = prime;
				// cursor++
			}
		}
		// return the a copy of primeAry without trailing nulls
		return Arrays.copyOf(primeAry, cursor);
	}
	
	/*
	 * statische Methode -Teil D
	 */
	public static int[] generiereNachEratosthenes(int n) {
		int primesLength = (int)Math.round(Math.log(n) / Math.log(2));
		boolean[] marked = new boolean[n - 1];
		AdditiveIntListe primes = new AdditiveIntListe(primesLength);
		for (int z = 2; z <= Math.sqrt(n); z++) {
			if (!marked[z-2]) {
				primes.add(z);
				for (int multiZ = z*z; multiZ <= n; multiZ += z) {
					marked[multiZ - 2] = true;
				}
			} 
		}
		
		for (int z = (int)Math.ceil(Math.sqrt(n)); z <= n;z++) {
			if (!marked[z-2]) 
				primes.add(z);
		}
		
		return primes.toArray();
	}
	
}