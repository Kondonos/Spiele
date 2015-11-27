package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Vocable implements Serializable{
	private static final long serialVersionUID = 1L;
	private String kana;
	private ArrayList<String> meaning;
	
	public Vocable(String kana,ArrayList<String> meaning) {
		this.kana=kana;
		this.meaning=meaning;
	}
	public String getKana() {
		return kana;
	}
	public ArrayList<String> getMeaning() {
		return meaning;
	}
}
