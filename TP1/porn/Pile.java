package partie3;

import java.util.Vector; 

/*
 Le premier �l�ment du conteneur est celui qui a �t� entr� en premier et le dernier est celui qui a �t� entr� en dernier
 On utilise aussi un vector pour le conteneur pour la meme raison que pour la file.
  */
public class Pile<item> {
	
	private Vector<item> conteneur;
	private int iterator = 0;
	
	Pile(){
		iterator = 0;		//on commence par pointer vers l'�l�ment le plus bas dans la pile
		conteneur = new Vector<item>();
	}
	
	public void empiler(item i) {
		conteneur.addElement(i);
	}
	
	public void depiler() {
		conteneur.remove(conteneur.lastElement()); 	//on enleve le dernier �l�ment 
	}
	
	public item getFirstElement() {
		return conteneur.lastElement();		//premier �l�ment du conteneur est le dernier �l�ment de la classe.
	}
	
	public boolean isEmpty() {
		return conteneur.isEmpty();
	}
	
	
	public item next() {
		iterator++;
		
		if(iterator > conteneur.size()) {
			iterator = conteneur.size()-1;
			System.out.println("On est rendu au premier �l�ment.");
			return conteneur.lastElement();
		}
		else {		
			System.out.println("Retour de l'�l�ment � la position : " + (iterator) );
			return conteneur.get(iterator);
		}
	}
	
	//ca na pas �t� demand� mais on a trouv� qu'une m�thode inverse existe.
	public item back() {
		iterator--;
		
		if(iterator < 0) {
			iterator ++;
		}
		
		if(iterator == 0) {
			System.out.println("On est rendu au dernier �l�ment.");
			return conteneur.get(0);
		}
		else {
			System.out.println("Retour de l'�l�ment � la position : " + (iterator) );
			return conteneur.get(iterator);
		}
	}
}