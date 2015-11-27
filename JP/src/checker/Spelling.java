package checker;

import java.io.IOException;

import data.Node;

public class Spelling {
	private Node root;
	
	public Spelling(Dictionary dictionary) {
		String[] keys=dictionary.getVocabs().keySet().toArray(new String[dictionary.getVocabs().size()]);
		root =new Node(null, "");
		
		for(String key:keys){
			
			build(root,(dictionary.getVocabs().get(key).getKana()+"$"));
		}
	}
	
	public void build(Node current,String suffix){
		if(suffix.length()==0)
			return;
		String[] parts=new String [2];
		parts[0]=suffix.substring(0, 1);
		parts[1]=suffix.substring(1);
		Node prev=null;
		
		if((prev=current.getChild().get(parts[0]))!=null){
			build(prev,parts[1]);
		}else{
			prev=new Node(current, parts[0]);
			build(prev,parts[1]);
		}	
	}
	
	public Node getRoot() {
		return root;
	}
}
