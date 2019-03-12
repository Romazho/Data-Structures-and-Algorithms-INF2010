import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    	this.money = data;
    	worstChild = this; // Le pire est lui même 
    	childs = new BinarySearchTree<CompanyNode>(this); // Initialisation necessaire ? //le root est this.

    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	money += item.money; // On ajoute l'argent à la compagnie
    	
    	childs.insert(item); // On ajoute un element à la compagnie
    	
    	// ====>>>>Verifier le pire child
    	List<BinaryNode<CompanyNode>> sortedItemList = item.childs.getItemsInOrder();
    	for(int i = 0; i < sortedItemList.size();++i) {
    		if(worstChild.compareTo(sortedItemList.get(i).getData()) > 0); // Si notre worst est plus grand que celui de sortedItemList 
    			worstChild = sortedItemList.get(i).getData();
    	}
    }

    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
        return money;
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {
    	
    	builder.append(this.getMoney() + "\n");
    	
    	List<BinaryNode<CompanyNode>> orderedList = childs.getItemsInOrder();
    	
    	boolean empty = orderedList.isEmpty();
    	
    	if(empty = false) {	//si la liste n'est pas vide
    		
	    	for(int i=orderedList.size();i > 0;--i) {
	    		//if(orderedList.get(i).) {	//si le noeud a un fils alors on rapelle cette fonction recursive
		    		builder.append(" > ");
		    		fillStringBuilderInOrder(builder,prefix);
	    		//}
	    	}
    	}
    }
    

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {
        return money.compareTo(item.money); // On utilise le comparateur des int pour déterminer si l'un est plus grand que l'autre
    }
}
