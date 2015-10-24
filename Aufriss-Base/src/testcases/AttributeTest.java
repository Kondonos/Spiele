package testcases;

import entity.feature.Attributes;

public class AttributeTest {

	public static void main(String[] args) {
		System.out.println("(1) Test with Constuctor1");
		Attributes test1=new Attributes();
		System.out.println(test1+"\n\n");
		System.out.println("(2) Test with addAttributes (add 2 to all attri.)-> all attr.=2");
		test1.addAttributes(2, 2, 2, 2, 2);
		System.out.println(test1+"\n\n");
		
		System.out.println("(3) Test3 Constructor2 with all attributes 3");
		Attributes test2=new Attributes(3,3,3,3,3);
		System.out.println(test2+"\n\n");
		System.out.println("(4) Test with addAttributes (add 2 to all attri.)-> all attr.=5");
		test2.addAttributes(2, 2, 2, 2, 2);
		System.out.println(test2+"\n\n");
		
		System.out.println("(5)Test getter-methodes for every attribute from Test(5)");
		System.out.println("Condition: "+test2.getCondition());
		System.out.println("\nStrength: "+test2.getStrength());
		System.out.println("\nDexterity: "+test2.getDexterity());
		System.out.println("\nAgility: "+test2.getAgility());
		System.out.println("\nIntelligence: "+test2.getIntelligence());
	}
}
