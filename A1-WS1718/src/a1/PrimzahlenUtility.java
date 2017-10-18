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
	public static int[] generierePrimZahlen(int bis) {
		int[] result = new int[bis];
		int[] prime_ary = new int[bis];
		int i = 0, prime = 2;
		int prime_count = 0;
		while (prime <= bis) {
			if (istPrimzahl(prime)) {
				prime_ary[i] = prime;
				i++;
				prime++;
				prime_count++;
			} else
				prime++;
		}
		for (int j = 0; j < prime_count; j++) {
			result[j] = prime_ary[j];
		}
		return result;
	}

	/*
	 * statische Methode -Teil D
	 */
	public static int[] generiereNachEratosthenes(int n) {
		int primes_length = (int)Math.round(Math.log(n) / Math.log(2));
		AdditiveIntListe primes = new AdditiveIntListe(primes_length);
		boolean[] marked = new boolean[n-1];
		for (int z = 2; z <= Math.sqrt(n); z++) {
			if (marked[z-2] == false) {
				primes.add(z);
				for (int notprime = z*z; notprime <= n; notprime += z) {
					marked[notprime - 2] = true;
				}
			} 
		}
		
		for (int z = (int)Math.ceil(Math.sqrt(n)); z <= n;z++) {
			if (marked[z-2] == false) 
				primes.add(z);
		}
		
		return primes.toArray();
	}
}
