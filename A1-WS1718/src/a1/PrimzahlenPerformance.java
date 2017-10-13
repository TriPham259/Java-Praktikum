package a1;

import static a1.PrimzahlenUtility.*;

public class PrimzahlenPerformance {


	public static void main(String[] args) {
		
		long st1 = System.currentTimeMillis();
		int n = 200000;
		generierePrimZahlen(n);
		System.out.println("Time elapsed ii_gen until " + n + " " + (System.currentTimeMillis()-st1) + "(ms)" );
		
		long st2 = System.currentTimeMillis();
		generiereNachEratosthenes(n);
		System.out.println("Time elapsed gen sieb until " + n + " " + (System.currentTimeMillis()-st2) + "(ms)" );
	}
}
