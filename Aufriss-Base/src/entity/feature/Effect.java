package entity.feature;

public class Effect {
	private String name;
	private double value;
	private boolean isActiv;
	
	public Effect(String name,double value,boolean isActiv) {
		this.name=name;
		this.value=value;
		this.isActiv=isActiv;
	}
	public Effect() {
		this.name="";
		this.value=0.0;
		this.isActiv=false;
	}
	public boolean toggleEffect(){
		return (this.isActiv= !this.isActiv);
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}
	public boolean isActiv() {
		return isActiv;
	}
	@Override
	public String toString() {
		String s="Name: "+this.name
				+"\nValue: "+this.value
				+"\nisActiv: "+this.isActiv;
		return s;
	}
	@Override
	public void finalize() throws Throwable {
		name=null;
		value=0;
		isActiv=false;
		super.finalize();
	}
}
