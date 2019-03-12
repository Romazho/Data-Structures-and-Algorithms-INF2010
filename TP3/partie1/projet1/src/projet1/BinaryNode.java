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
			if (right == null)
				right = new BinaryNode<T>(item);
			else
				right.insert(item);

		} else {
			if (left == null)
				left = new BinaryNode<T>(item);
			else
				left.insert(item);
		}

	}

	// TODO: est-ce que l'item fais partie du noeuds courant
	// O(log(n))
	public boolean contains(T item) {

		if (item.compareTo(data) == 0) {
			return true;

		} else if ((right != null) && (data.compareTo(item) < 0)) {
			return right.contains(item);
		}

		else if ((left != null) && (data.compareTo(item) >= 0)) {
			return left.contains(item);

		} else {

			return false;
		}
	}

	// TODO: on retourne la maximale de l'arbre
	// O(n)
	public int getHeight() {

		int hauteurGauche = -1, hauteurDroit = -1; // On ne peut pas les d�clarer dans les if
		
		if ((left == null) && (right == null)) //Si le dernier noeud
			return 0;
		
		if (left != null) 
			hauteurGauche = left.getHeight();
		
		if (right != null)
			hauteurDroit = right.getHeight();

		if (hauteurGauche > hauteurDroit) // On veux seulement la valeur la plus grosse
			return (++hauteurGauche);
		else
			return (++hauteurDroit);
	}

	// TODO: l'ordre d'insertion dans la liste est l'ordre logique
	// de manière que le plus petit item sera le premier inseré
	// O(n)
	public void fillListInOrder(List<BinaryNode<T>> result) {
		if (left == null) { //Verifier que l'element suivant n'est pas null avant <-
			result.add(this);
			
			if (right == null) { //Verifier que l'element suivant n'est pas null avant ->
				return;
			}
			right.fillListInOrder(result); // on va a droite
			
			return;
		}
		left.fillListInOrder(result); // on va a gauche

		result.add(this); // on ajoute l'element O

		if (right == null) { //Verifier que l'element suivant n'est pas null avant ->
			return;
		}
		right.fillListInOrder(result); // on va a droite
	}
}
