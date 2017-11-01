package a1;

import java.util.Arrays;

// abstrakter Datentyp Teil C
public class AdditiveIntListe {

	// TODO
	private int[] intern;
	private int kapazitaet;
	private int cursor;
	
	public AdditiveIntListe(int kapazitaet) {
		// TODO
		this.intern = new int[kapazitaet];
		this.kapazitaet = kapazitaet;
		this.cursor = 0; 
	}
	
	public AdditiveIntListe() {
		// TODO
		this(10);
	}

	// add Methode
	public void add(int value) {
		if (cursor >= intern.length) 
			intern = Arrays.copyOf(intern, intern.length + kapazitaet);
		intern[cursor] = value;
		cursor++;
	}
	
	// size Methode
	public int size() {
		return cursor;
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