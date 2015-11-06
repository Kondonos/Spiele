package testcases;


import item.Item;

public class ItemTest {
	public static void main(String[] args) {
		System.out.println("(1) Test item without parameters");
		Item[] item =new Item[2];
		item[0]=new Item();
		System.out.println(item[0]+"\n\n");
		
		System.out.println("(2) Test change attributes from (1) to name->Healing Potion, text->it heals, maxSize->10, currentSize->5, effect->health regeneration & 20 & isActiv");
	
		item[0].setName("Healing Potion");
		item[0].setText("It heals!!");

		System.out.println(item[0]+"\n\n");
		
		System.out.println("(3) Test new item with name->Healing Potion II, text->it heals more, maxSize->5, currentSize->1, effect->health regeneration & 50 & isn't Activ");
;
		item[0].setName("Healing Potion II");
		item[0].setText("It heals more!!");

		System.out.println(item[0]+"\n\n");
		
		System.out.println("(4) Test increase the amount from the item (3) of 7( add 6 get 2 itemstacks)");

		System.out.println(item[0]+"\n\n"+item[1]+"\n\n");
		
		System.out.println("(5) Test decrease the amount of item from (4) to 4 (sub. 3 delete a itemstack)");

		System.out.println(item[0]+"\n\n"+item[1]+"\n\n");
		
	}
}
