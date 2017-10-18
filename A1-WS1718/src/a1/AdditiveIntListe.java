package a1;

import java.util.Arrays;

// abstrakter Datentyp Teil C
public class AdditiveIntListe {

	// TODO
	private int kapazitaet;
	private int[] intern;
	private int cursor;
	
	public AdditiveIntListe(int kapazitaet) {
		// TODO
		this.kapazitaet = kapazitaet;
		this.cursor = 0;
		this.intern = new int [kapazitaet];
	}
	
	public AdditiveIntListe() {
		this.kapazitaet = 0;
		this.cursor = 0;
		this.intern = new int [kapazitaet];
	}

	// add Methode
	public int[] add(int value) {
		if (cursor < intern.length) {
			intern[cursor] = value;
		} else {
			intern =  Arrays.copyOf(intern, kapazitaet * 2);
			intern[cursor] = value;
		}
		return intern;
	}
	
	// size Methode
	public int size() {
		return this.cursor;
	}
	
	// toArray Methode
	public int[] toArray() {
		return Arrays.copyOf(intern, size());
	}
	
	// to String Methode
	public String toString() {
		return Arrays.toString(toArray());
	}
}
