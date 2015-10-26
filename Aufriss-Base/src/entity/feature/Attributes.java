package entity.feature;

public class Attributes {
	 private int[] attributes;
	
	
	public Attributes() {
		this.attributes=new int[5];
		for(int i=0;i<this.attributes.length;i++){
			this.attributes[i]=0;
		}
	}
	public Attributes(int condition,int strength,int dexterity,int agility,int intelligence){
		this();
		attributes[0]=condition;
		attributes[1]=strength;
		attributes[2]=dexterity;
		attributes[3]=agility;
		attributes[4]=intelligence;
	}
	@Override
	public String toString() {
		String s="Condition: "+attributes[0]
				+"\nStrength: "+attributes[1]
				+"\nDexterity: "+attributes[2]
				+"\nAgility: "+attributes[3]
				+"\nIntelligence: "+attributes[4];
		return s;
	}
	public void addAttributes(int condition,int strength,int dexterity,int agility,int intelligence){
		attributes[0]+=condition;
		attributes[1]+=strength;
		attributes[2]+=dexterity;
		attributes[3]+=agility;
		attributes[4]+=intelligence;
	}
	
	public int getCondition() {
		return attributes[0];
	}
	public int getStrength() {
		return attributes[1];
	}
	public int getDexterity() {
		return attributes[2];
	}
	public int getAgility() {
		return attributes[3];
	}
	public int getIntelligence() {
		return attributes[4];
	}
}
