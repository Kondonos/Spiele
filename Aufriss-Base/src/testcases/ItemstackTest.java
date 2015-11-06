package testcases;

import item.Item;
import item.Itemstack;

public class ItemstackTest {
	public static void main(String[] args) throws Throwable {
		System.out.println("(1) Test create itemstack from item iron ore and wiht amount of 10 and max size of 100");
		Itemstack stack= new Itemstack(new Item("Iron Ore","it's iron"), 100, 10);
		System.out.println(stack.toString()+"\n\n");
		
		System.out.println("(2) Test (1) add to 100 ");
		int i=stack.additem(100);
		System.out.println(stack.toString()+"\nRest: "+i+"\n\n");
		
		System.out.println("(3) Test (2) sub 110 (finalize off)");
		int j=stack.subitem(110);
		System.out.println(stack.toString()+"Rest: "+j+"\n\n");
		
		System.out.println("(4) Test (1)add itemstack of iron ore wiht size of 5");
		stack= new Itemstack(new Item("Iron Ore","it's iron"), 100, 10);
		Itemstack stack2= new Itemstack(new Item("Iron Ore","it's iron"), 100, 15);
		int k=stack.additem(stack2);
		System.out.println(stack.toString()+"rest: "+k+"\n\n");
		
		System.out.println("(5) Test (4) add itemstack of dirt wiht maxsize 500 and current 100");
		Itemstack dirt=new Itemstack(new Item("Dirt^", "its dirty!"), 500, 100);
		int l=stack.additem(dirt);
		System.out.println(stack.toString()+"Rest: "+l+"\n\n");
	}
}
