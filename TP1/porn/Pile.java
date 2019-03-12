package partie3;

import java.util.Vector; 

/*
 Le premier élément du conteneur est celui qui a été entré en premier et le dernier est celui qui a été entré en dernier
 On utilise aussi un vector pour le conteneur pour la meme raison que pour la file.
  */
public class Pile<item> {
	
	private Vector<item> conteneur;
	private int iterator = 0;
	
	Pile(){
		iterator = 0;		//on commence par pointer vers l'élément le plus bas dans la pile
		conteneur = new Vector<item>();
	}
	
	public void empiler(item i) {
		conteneur.addElement(i);
	}
	
	public void depiler() {
		conteneur.remove(conteneur.lastElement()); 	//on enleve le dernier élément 
	}
	
	public item getFirstElement() {
		return conteneur.lastElement();		//premier élément du conteneur est le dernier élément de la classe.
	}
	
	public boolean isEmpty() {
		return conteneur.isEmpty();
	}
	
	
	public item next() {
		iterator++;
		
		if(iterator > conteneur.size()) {
			iterator = conteneur.size()-1;
			System.out.println("On est rendu au premier élément.");
			return conteneur.lastElement();
		}
		else {		
			System.out.println("Retour de l'élément à la position : " + (iterator) );
			return conteneur.get(iterator);
		}
	}
	
	//ca na pas été demandé mais on a trouvé qu'une méthode inverse existe.
	public item back() {
		iterator--;
		
		if(iterator < 0) {
			iterator ++;
		}
		
		if(iterator == 0) {
			System.out.println("On est rendu au dernier élément.");
			return conteneur.get(0);
		}
		else {
			System.out.println("Retour de l'élément à la position : " + (iterator) );
			return conteneur.get(iterator);
		}
	}
}