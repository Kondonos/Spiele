package item;

import entity.feature.Effect;

public class Item {
	private String name,text;
	private int stackSize;
	private int maxStackesize;
	private Effect effect;
	
	public Item(String name, String text,int stackSize,int maxStackSize, Effect effect) {
		this.name=name;
		this.text=text;
		this.maxStackesize=maxStackSize;
		this.stackSize=stackSize;
		this.effect=effect;
	}
	public Item() {
		this.name="";
		this.text="";
		this.maxStackesize=0;
		this.stackSize=0;
		this.effect=new Effect();
	}	
	
	public Item addItemToStack(int amount){
		int i=0;
		if((i=this.stackSize+amount)>this.maxStackesize){
			this.stackSize=this.maxStackesize;
			Item item=new Item(this.name,this.text,i%this.maxStackesize,this.maxStackesize,this.effect);
			return item;
		}else
			return null;
	}
	public int takeItem(int amount){
		int i=this.stackSize-amount;
		if(i<1){
			try {
				this.finalize();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			return i*(-1);
		}else{
			this.stackSize=i;
			return i;
		}
	}
	
	public Effect getEffect() {
		return effect;
	}
	public int getMaxStackesize() {
		return maxStackesize;
	}
	public String getName() {
		return name;
	}
	public int getStackSize() {
		return stackSize;
	}
	public String getText() {
		return text;
	}
	
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	public void setMaxStackesize(int maxStackesize) {
		this.maxStackesize = maxStackesize;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	protected void finalize() throws Throwable {
		this.effect.finalize();
		this.maxStackesize=0;
		this.stackSize=0;
		this.text=null;
		this.name=null;
		super.finalize();
	}
	@Override
	public String toString() {
		String s="Name: "+name+"\nText: "+text+"\nMax Size: "+maxStackesize+"\nCurrent size: "+stackSize+"\nEffect: \n"+effect;
		return s;
	}
}
