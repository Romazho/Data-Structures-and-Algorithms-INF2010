package partie3;
/**
 * LinkedList class implements a doubly-linked list.
 */
@SuppressWarnings("hiding")
public class Sac<Item> implements Iterable<Item>
{
	private int taille; // Taille de la liste
	private int compteurModification; // Permet de compter les modifications faites 
    private Node<Item> head;
    private Node<Item> tail;
    
    public  Sac( ) // Constructeur qui permet de construire une liste liée vide
    {
        clear( );
    }
    
    //Remet la taille de la liste à zéro
    public void clear( )
    {
        head = new Node<Item>( null, null, null );
        tail = new Node<Item>( null, head, null );
        head.next = tail;
        
        compteurModification ++;
        taille = 0;
    }
    
    //Retourne la taille de la liste
    public int getSize( ) 
    {
        return taille;
    }
    // Retourne si la liste est vide
    public boolean isEmpty( )
    {
    	int vide = 0;
        return getSize( ) == vide;
    }
    
    //Ajoute un "Item" à la fin
    public boolean add( Item x )
    {
        add( getSize( ), x );   
        return true;         
    }
    
    // Ajoute un "Item" a un index specifie
    public void add( int index, Item x )
    {
        addBefore( getNode( index, 0, getSize( ) ), x );
    }
    
    // Ajoute un "Item" a un index specifie
    private void addBefore( Node<Item> objTemp, Item x )
    {
        Node<Item> newNode = new Node<Item>( x, objTemp.prev, objTemp );
        newNode.prev.next = newNode;
        objTemp.prev = newNode;         
        compteurModification++;
        
        taille++;
    }   
    

    //Methode de modification d'un "Item" à un index spéficié avec un "Item"
    public Item set( int index, Item newVal )
    {
        Node<Item> objTemp = getNode( index );
        Item oldVal = objTemp.data;
        
        objTemp.data = newVal;   
        return oldVal;
    }
    
    private Node<Item> getNode( int index )
    {
        return getNode( index, 0, getSize( ) - 1 );
    }


    private Node<Item> getNode( int index, int lower, int upper )
    {
        Node<Item> objTemp;
        //Selon les notes de cours
        if( index < lower || index > upper )
            throw new IndexOutOfBoundsException( "getNode index: " + index + "; Taille: " + getSize( ) );
            
        if( index < getSize( ) / 2 )
        {
            objTemp = head.next;
            for( int i = 0; i < index; i++ )
                objTemp = objTemp.next;            
        }
        else
        {
            objTemp = tail;
            for( int i = getSize( ); i > index; i-- )
                objTemp = objTemp.prev;
        } 
        
        return objTemp;
    }
    
    
    //Retourne un itérateur positionné sur le premier element
    public java.util.Iterator<Item> iterator( )
    {
        return new Iterateur( );
    }


    private class Iterateur implements java.util.Iterator<Item>
    {
        private Node<Item> current = head.next;
        private int nbModAttendue = compteurModification; // Permet de vérifier si il n'y a pas eu de modification entre le "monde réel" et l'itérateur

        
        public boolean hasNext( )
        {
            return current != tail;
        }
        
        public Item next( )
        {
        	if (nbModAttendue != compteurModification) {
        		throw new java.util.ConcurrentModificationException("L’itérateur n'est pas cohérent par rapport aux modifications");
        	}
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException("Il n'y a pas de prochain élément" ); 
                   
            Item nextItem = current.data;
            current = current.next;
            return nextItem;
        }
        
    }
    

    private static class Node<Item>
    {
        public Node( Item d, Node<Item> p, Node<Item> n )
        {
            data = d; prev = p; next = n;
        }
        
        public Item data;
        public Node<Item>   prev;
        public Node<Item>   next;
    }
    
    
}