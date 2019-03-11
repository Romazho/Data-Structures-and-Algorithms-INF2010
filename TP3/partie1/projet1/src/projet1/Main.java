package projet1;

// Toute modification a ce fichier ne sera pas comptabilisée
public class Main {

    // Le main fait simplement tester votre logique pour les deux exercices

    public static void main(String[] args) {
        System.out.println("Debut des tests du TP3");
        TestBinary testBinary = new TestBinary();
        testBinary.test();
        testBinary.test();
        /*DEBUG
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(4);
        
       if( tree.contains(3))
    	   System.out.println("Contient 3");
       System.out.println(tree.getHeight());
       */
    }
    
}
