package a1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a1.AdditiveIntListe;

public class AdditiveListeTest {
	
	private AdditiveIntListe al;
	@Before
	public void data(){
		al = new AdditiveIntListe();
	}
	@Test
	public void testAddAndSize(){
		assertEquals(0,al.size());
		al.add(4);
		al.add(7);
		al.add(133);
		assertEquals(3,al.size());
		assertArrayEquals(new int[] {4,7,133},al.toArray());
	}

	@Test
	public void testBoundaryAddAndSize(){
		AdditiveIntListe alB = new AdditiveIntListe(1);
		assertEquals(0,alB.size());
		alB.add(4);
		alB.add(7);
		alB.add(133);
		assertEquals(3,alB.size());
		assertArrayEquals(new int[] {4,7,133},alB.toArray());
	}
}
