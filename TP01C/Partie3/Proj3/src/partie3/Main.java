package partie3;



class Item{
	private int nombre_;
	Item(){
		nombre_ = 0;
	}
	Item(int nombre){
		nombre_ = nombre;
	}
	public int getNombre() {
		return nombre_;
	}
	
	public void setNombre(int nombre) {
		nombre_ = nombre;
	}
}

public class Main { 
	
	public static void main(String [] args) {

	/*Initialisation des Pile, file , sac*/
	Pile<Item> pile = new Pile<Item>();
	File<Item> file = new File<Item>();
	Sac<Item> sac = new Sac<Item>();
	
	//Tableau d'item
	Item [] itemList ;
	itemList = new Item[5];
	//Ajouter les item dans les conteneurs
	for(int i = 0; i < itemList.length;i++) {
		itemList[i] = new Item(i); // Initialisation des item
		pile.empiler(itemList[i]);
		file.enfiler(itemList[i]);
		sac.add(itemList[i]);
	}
	if(pile.isEmpty() == true) {System.out.println("La pile est  vide");}
	else {System.out.println(pile.toString() +" n'est pas vide");}
	
	if(file.isempty() == true) {System.out.print("La file est vide");}
	else {System.out.println(file.toString() +" n'est pas vide");}
	
	if(pile.isEmpty() == true) {System.out.print("La sac est vide");}
	else {System.out.println(sac.toString() +" n'est pas vide");}
	
	}
	
}