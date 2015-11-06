package item;

public class Itemstack {
	Item item;
	int max;
	int current;
	
	public Itemstack(Item item, int max, int current) {
		this.item=item;
		this.max=max;
		this.current=current;
	}
	public int additem(Itemstack itemstack){
		if(this.item.equals(itemstack.item)){
			this.current+=itemstack.getCurrent();
			if(this.current>=this.max){
				int rest=current%max;
				current=max;
				return rest;
			}else return 0;
		}else return itemstack.getCurrent();
	}
	public int additem(int count){
		this.current+=count;
		if(this.current>=this.max){
			int rest=current%max;
			current=max;
			return rest;
		}else return 0;
	}
	public int subitem(int count) throws Throwable{
		this.current-=count;
		if(this.current<=0){
			this.finalize();
			return -1*this.current;
		}else return 0;	
	}
	@Override
	protected void finalize() throws Throwable {
		this.item=null;
		this.current=0;
		this.max=0;
		super.finalize();
	}
	
	
	public int getCurrent() {
		return current;
	}
	public Item getItem() {
		return item;
	}
	public int getMax() {
		return max;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public String toString() {
		String s=this.item.toString()+"\nMaxSize: "+this.max+"\nCurrent: "+this.current;
		return s;
	}
}
