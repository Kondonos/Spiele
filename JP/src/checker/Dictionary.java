package checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import data.Vocable;

public class Dictionary implements Serializable{
	private static final long serialVersionUID = 1L;
	HashMap<String, Vocable> vocabs;
	
	@SuppressWarnings("unchecked")
	public Dictionary() {
		File file=new File("./assets/dictionary.dic");
		this.vocabs=new HashMap<>();
		if(file.exists()&&file.isFile()){
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				ObjectInputStream ois=new ObjectInputStream(fis);
				this.vocabs=(HashMap<String, Vocable>)ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (!file.exists()) {
			try {
				file.createNewFile();
				File ftxt=new File("./assets/dictionary.txt");
				if(file.exists()){
					BufferedReader br=new BufferedReader(new FileReader(ftxt));
					String tmp="";
					while((tmp=br.readLine())!=null){
						String value=new String(tmp.getBytes("UTF-8"));
						StringTokenizer tokenizer=new StringTokenizer(value, "\t");
						String key=tokenizer.nextToken(), 
								kana=tokenizer.nextToken();
						StringTokenizer tokenMeaning=new StringTokenizer(tokenizer.nextToken(),";");
						ArrayList<String> meaning=new ArrayList<>();
						while(tokenMeaning.countTokens()!=0){
							meaning.add(tokenMeaning.nextToken());
						}
						this.vocabs.put(key, new Vocable(kana, meaning));
					}
					br.close();
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutput oo = new ObjectOutputStream(fos);
					oo.writeObject(this.vocabs);
					oo.flush();
					oo.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			vocabs=null;
		}
	}
	
	public void addMeaningTo(String romanji,String meaning){
		((Vocable)this.vocabs.get(romanji)).getMeaning().add(meaning);
	}
	
	private void updatefile(){
		File file=new File("./assets/dictionary.dic");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutput oo = new ObjectOutputStream(fos);
			oo.writeObject(this.vocabs);
			oo.flush();
			oo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	public void addvocab(String romanji, ArrayList<String> meaning, String kana ){
		this.vocabs.put(romanji, new Vocable(kana, meaning));
		updatefile();
	}
	public HashMap<String, Vocable> getVocabs() {
		return vocabs;
	}
}
