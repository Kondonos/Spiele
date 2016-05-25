package simpleParser;

import java.util.HashMap;

public class Lexikon {
	public HashMap<String, String[]> lexikon;
	
	public Lexikon() {
		lexikon=new HashMap<>();
		fillLexikon();
	}
	private void fillLexikon(){
		lexikon.put("n",new String[]{"mann","frau"});
		lexikon.put("v",new String[]{"sieht"});
		lexikon.put("det",new String[]{"der","die"});
	}
}
