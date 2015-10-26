package testcases;

import entity.feature.Effect;
import item.Item;

public class ItemTest {
	public static void main(String[] args) {
		System.out.println("(1) Test item without parameters");
		Item[] item =new Item[2];
		item[0]=new Item();
		System.out.println(item[0]+"\n\n");
		
		System.out.println("(2) Test change attributes from (1) to name->Healing Potion, text->it heals, maxSize->10, currentSize->5, effect->health regeneration & 20 & isActiv");
		item[0].setEffect(new Effect("Health regeneration",20, true));
		item[0].setMaxStackesize(10);
		item[0].setName("Healing Potion");
		item[0].setText("It heals!!");
		item[0].setStackSize(5);
		System.out.println(item[0]+"\n\n");
		
		System.out.println("(3) Test new item with name->Healing Potion II, text->it heals more, maxSize->5, currentSize->1, effect->health regeneration & 50 & isn't Activ");
		item[0].setEffect(new Effect("Health regeneration",50, false));
		item[0].setMaxStackesize(5);
		item[0].setName("Healing Potion II");
		item[0].setText("It heals more!!");
		item[0].setStackSize(1);
		System.out.println(item[0]+"\n\n");
		
		System.out.println("(4) Test increase the amount from the item (3) of 7( add 6 get 2 itemstacks)");
		item[1]=item[0].addItemToStack(6);
		System.out.println(item[0]+"\n\n"+item[1]+"\n\n");
		
		System.out.println("(5) Test decrease the amount of item from (4) to 4 (sub. 3 delete a itemstack)");
		int i=item[1].takeItem(3);
		item[0].takeItem(i);
		System.out.println(item[0]+"\n\n"+item[1]+"\n\n");
		
	}
}
