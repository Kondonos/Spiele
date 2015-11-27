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
		boolean is;
		is=traverse(root,word);
		return is;
	}
	
	private boolean traverse(Node current,String word){
		String[] parts={word.substring(0,1),word.substring(1)};
		Node next=current.getChild().get(parts[0]);
		if(next==null){
			return false;
		}else{
			if(!next.isLeaf()){
				boolean isword=traverse(next, parts[1]);
				if(isword==true)
					return true;
				else
					return false;
			}else{
				return true;
			}
		}
		
	}	
}
