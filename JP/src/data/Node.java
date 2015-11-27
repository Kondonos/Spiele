package data;

import java.util.HashMap;

public class Node {
	private Node parent;
	private HashMap<String, Node> child;
	private boolean isLeaf;
	private String vocab;
	private String step;
	
	public Node(Node parent, String step) {
		this.parent=parent;
		child=new HashMap<>();
		isLeaf=true;
		this.step=step;
		if(parent==null){
			vocab=step;
		}else{
			addtoParent();
			vocab=parent.getVocab()+step;
		}
		
		
	}
	
	public void addtoParent() {
		this.parent.setLeaf(false);
		parent.child.put(step, this);
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public void setVocab(String vocab) {
		this.vocab = vocab;
	}
	public HashMap<String, Node> getChild() {
		return child;
	}
	public Node getParent() {
		return parent;
	}
	public String getStep() {
		return step;
	}
	public String getVocab() {
		return vocab;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
}
