public class CompanyTree {

    private CompanyNode root;

    public CompanyTree() { }

    // TODO: initialisation
    public CompanyTree(CompanyNode item) {
    	this.root = item;	//est-ce que c'est tout?
    }

    // TODO: une compagnie mere achete une autre compagnie
    // O(n)
    public void buy(CompanyNode item) {
    	
    	root.buy(item);
    }

    // TODO: on retourne le montant en banque de la compagnie mere
    // O(1)
    public Integer getMoney() {
        return root.getMoney();
    }

    // TODO: si on avait a laisser tomber un enfant, ca serait lui
    // Ceci est le pire de tous les enfants et les sous-enfants
    // O(1)
    public Integer getWorstChildMoney() {
        return root.worstChild.getMoney();
    }

    // TODO: on retourne en string un presentation en ordre inverse
    // de la compagnie mere et de ses enfants
    // O(1)
    public String getTreeInOrder() {
    	
    	String prefix = "";
    	StringBuilder builder = new StringBuilder();
    	root.fillStringBuilderInOrder(builder,prefix);
    	
        return builder.substring(0);
    }
}
