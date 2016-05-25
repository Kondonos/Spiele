package simpleParser;

import java.util.ArrayList;

public class Chart {
	ArrayList<Item> chart;
	
	public Chart(String[][] regel) {
		chart=new ArrayList<>();
		for (String[] strings : regel) {
			Item item=new Item();
			item.setRegel(strings);
			chart.add(item);
		}
	}
	public void additem(Item item){
		chart.add(item);
	}
	public void additem(int start,int ende, String[] regel,int pos){
		Item item =new Item(start, ende, regel, pos);
		additem(item);
	}
	
	public ArrayList<Item> findCompamion(Item item){
		ArrayList<Item> companions=new ArrayList<>();
		for (Item i : chart) {
			if(i.getEnde()==item.getStart())
				if(item.getRegel().length>i.pos) 
					if(item.getRegel())
		}
	}
}
