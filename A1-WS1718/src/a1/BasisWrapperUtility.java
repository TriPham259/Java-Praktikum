package a1;

import java.util.Arrays;

public class BasisWrapperUtility {

	public static void main(String[] args) {
		long[][] lA = { { 1, 2 }, { 1, 2, 3, 4, 5, 6, 7 } };

		System.out.println(Arrays.deepToString(toLong2D(lA)));
	}

	// statische Methoden (2) zu Teil A 4.
	public static Long[][] toLong2D(long[][] lAry) {
		// allocate the size for longAry's rows
		Long longAry[][] = new Long[lAry.length][];
		
		for (int i = 0; i < lAry.length; i++) {
			// allocate the size for longAry's columns
			longAry[i] = new Long[lAry[i].length];
			for (int j = 0; j < lAry[i].length; j++)
				longAry[i][j] = new Long(lAry[i][j]);
		}
		return longAry;
	}

	public static Float[][] toFloat2D(float[][] fAry) {
		Float floatAry[][] = new Float[fAry.length][];
		
		for (int i = 0; i < fAry.length; i++) {
			floatAry[i] = new Float[fAry[i].length];
			for (int j = 0; j < fAry[i].length; j++)
				floatAry[i][j] = new Float(fAry[i][j]);
		}
		return floatAry;
	}

	// statische Methode (1) zu Teil A 5.
	public static Long[][] toLong2D(int[][] iAry) {
		Long longAry[][] = new Long[iAry.length][];
		
		for (int i = 0; i < iAry.length; i++) {
			longAry[i] = new Long[iAry[i].length];
			for (int j = 0; j < iAry[i].length; j++)
				longAry[i][j] = new Long(iAry[i][j]);
		}
		return longAry;
	}

}