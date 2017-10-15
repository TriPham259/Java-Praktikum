package a1.test;

import static a1.PrimzahlenUtility.generiereNachEratosthenes;
import static a1.PrimzahlenUtility.generierePrimZahlen;
import static a1.PrimzahlenUtility.istPrimzahl;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PrimzahlenUtilityTest {

	int[] primeBis100;
	int[] primeBis200;
	int keinePrimZahl = 164;
	int kleinsteKeinePrimzahl = 4;
	int primZahl = 97;
	int kleinstePrimZahl = 2;


	@Before
	public void primzahlenSaetze() {
		primeBis100 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
				83, 89, 97 };
		primeBis200 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
				83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
				193, 197, 199 };
	}

	@Test
	public void einzelnePrimzahlen() {
		assertTrue(istPrimzahl(kleinstePrimZahl));
		assertTrue(istPrimzahl(primZahl));
		assertFalse(istPrimzahl(keinePrimZahl));
		assertFalse(istPrimzahl(kleinsteKeinePrimzahl));
	}

	@Test
	public void primzahlenGen() {
		assertArrayEquals(primeBis100, generierePrimZahlen(100));
		assertArrayEquals(primeBis200, generierePrimZahlen(200));

	}

	@Test
	public void primzahlenGenMitSieb() {
		System.out.println(Arrays.toString(generiereNachEratosthenes(100)));
		assertArrayEquals(primeBis100, generiereNachEratosthenes(100));
		assertArrayEquals(primeBis200, generiereNachEratosthenes(200));
	}

}
