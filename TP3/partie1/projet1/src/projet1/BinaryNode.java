package projet1;

import java.util.List;

public class BinaryNode<T extends Comparable<? super T>> {
	private T data;
	private BinaryNode<T> right;
	private BinaryNode<T> left;

	// TODO: initialisation
	// O(1)
	public BinaryNode(T data) {
		this.data = data;
		right = null;
		left = null;
	}

	// TODO: on retourne la donnee voulue
	// O(1)
	public T getData() {
		return data;
	}

	// TODO: on ajoute une nouvelle donnee au bon endroit
	// O(log(n))
	public void insert(T item) {
		
		if (data.compareTo(item) < 0) {
			right = new BinaryNode<T>(item);
		} else {
			left = new BinaryNode<T>(item);
		}
		
	}

	// TODO: est-ce que l'item fais partie du noeuds courant
	// O(log(n))
	public boolean contains(T item) {

		if (item.compareTo(data) == 0) {
			return true;

		}
		else if ((right == null) && (data.compareTo(item) < 0)) {
			return right.contains(item);
		}

		else if ((left == null) && (data.compareTo(item) >= 0)) {
			return left.contains(item);

		} 
		else {

			return false;
		}
	}

	// TODO: on retourne la maximale de l'arbre
	// O(n)
	public int getHeight() {
		
		if(this == null) {
			return -1;
		}
		else {
			return 1 + Math.max(left.getHeight(),right.getHeight());
		}
		
	}

	// TODO: l'ordre d'insertion dans la liste est l'ordre logique
	// de manière que le plus petit item sera le premier inseré
	// O(n)
	public void fillListInOrder(List<BinaryNode<T>> result) {
		
		left.fillListInOrder(result); //on va a gauche
		
		if(left == null) {
			return;
		}
		
		result.add(this);				//on ajoute l'element
		
		right.fillListInOrder(result);	//on va a droite
		
		if(right == null) {
			return;
		}
		
		
	}
}













