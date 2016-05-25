package simpleParser;

public class Item {
	public int start,ende,pos;
	public String[] regel;
	
	public Item() {
		start=0;
		ende=0;
		pos=0;
		regel=null;
	}
	public Item(int start,int ende, String[] regel,int pos){
		this.regel=regel;
		this.ende=ende;
		this.start=start;
		this.pos=pos;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnde() {
		return ende;
	}
	public void setEnde(int ende) {
		this.ende = ende;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String[] getRegel() {
		return regel;
	}
	public void setRegel(String[] regel) {
		this.regel = regel;
	}
	
}
