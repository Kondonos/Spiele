package checker;

import data.Node;

public class Spellchecker {
	private Spelling spelling;
	
	public Spellchecker(Spelling spelling) {
		this.spelling=spelling;
	}
	
	public boolean isWord(String word){
		word+="$";
		Node root=spelling.getRoot();
		boolean is=false;
		travers(root,word,is);
		return false;
	}
	
	private boolean traverse(Node current,String word, boolean isword){
		String[] parts={word.substring(0,1),word.substring(1)};
		if(isword==false){
			Node next=current.getChild().get(parts[0]);
			if(next==null){
				return false;
			}else if (isword) {
				
			}
		}
		
	}
	
}
