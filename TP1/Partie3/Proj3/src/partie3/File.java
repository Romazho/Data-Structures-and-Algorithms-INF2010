package partie3;

import java.util.Vector; 

/*
 on utilise un vector comme un conteneur pour cette classe, car on trouve que ca facilite la lecture et la compréhension de la classe et car cela n'a pas été précisé 
 quel type de conteneur il fallait utilier pour cette classe.
 */

public class File <item> {
	
	private Vector<item> conteneur;
	private int iterator = 0;
	
	File(){ 
		iterator = 0;
		conteneur = new Vector<item>();
	}

	                
	public void enfiler(item i) {
		conteneur.addElement(i);
	}
	
	public void defiler() {	//dans cette fonction on enleve le premier élément de la file et on tasse tous les éléments vers la gauche.
		conteneur.remove(0);
		iterator --;	//pour que l'iterateur point sur le meme élément qu'avant
	}
	
	public item getFirstElement() {
		return conteneur.firstElement();
	}
	
	public boolean isempty() {
		return conteneur.isEmpty();
	}
	
	public item next(){		//on retourne le prochian item
		iterator ++;
		
		if(iterator > conteneur.size()) {
			iterator = conteneur.size()-1;
			System.out.println("Le dernier élément a été parcouru!");
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
			System.out.println("On est rendu au premier élément.");
			return conteneur.get(0);
		}
		else {
			System.out.println("Retour de l'élément à la position : " + (iterator) );
			return conteneur.get(iterator);
		}
	}
}