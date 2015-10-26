package entity.feature;

import item.Item;

public class Drop {
	private Item item;
	private double likelihood;
	private int maxDropSize;
	
	public Drop(Item item, double like,int maxSize) {
		this.item=item;
		this.likelihood=like;
		this.maxDropSize=maxSize;
	}
	public Drop() {
		this.item=new Item();
		this.likelihood=0.0;
		this.maxDropSize=0;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	public void setLikelihood(double likelihood) {
		this.likelihood = likelihood;
	}
	public void setMaxDropSize(int maxDropSize) {
		this.maxDropSize = maxDropSize;
	}
	public Item getItem() {
		return item;
	}
	public double getLikelihood() {
		return likelihood;
	}
	public int getMaxDropSize() {
		return maxDropSize;
	}
	
	
}
