package testcases;

import entity.feature.Effect;

public class EffectTest {
	public static void main(String[] args) {
		System.out.println("(1) Test empty effect");
		Effect test1=new Effect();
		System.out.println(test1+"\n\n");
		
		System.out.println("(2) Test effect with Health regneration, 20, not activ");
		Effect test2=new Effect("Health regeneration", 20, false);
		System.out.println(test2+"\n\n");
		
		System.out.println("(3) Test toggle effect from Test (2)");
		test2.toggleEffect();
		System.out.println(test2+"\n\n");
		
		System.out.println("(4) Test getter from effect (3)");
		System.out.println("Name: "+test2.getName());
		System.out.println("\nValue: "+test2.getValue());
		System.out.println("\nisActiv:"+test2.isActiv());
	}
}
