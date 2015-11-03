package item;

import entity.feature.Effect;

public class Item {
	private String name,text;

	
	public Item(String name, String text) {
		this.name=name;
		this.text=text;
	}
	public Item() {
		this.name="";
		this.text="";
	}	
	

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}
	@Override
	protected void finalize() throws Throwable {
		this.text=null;
		this.name=null;
		super.finalize();
	}
	@Override
	public String toString() {
		String s="Name: "+name+"\nText: "+text;
		return s;
	}
}
