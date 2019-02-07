package tp2;

import java.util.ArrayList;


class Item{
	public Item(int i){
		nombre =i;
	}
	public int nombre;
}

public class Main {

	/*public ArrayList<int> randomIntegers() {
		
		return;
	}*/
	

	
	public static void main(String[] args) {
		
		ArrayList<Item>  array = new ArrayList<Item>(7);
		
		for(int i=0;i<array.size();i++) {
			Item a = new Item(i);
			array.add(a);
		}
		
		
		LinearSpacePerfectHashing<Item> date = new LinearSpacePerfectHashing(array);
		
		String a = date.toString();

	}

}
