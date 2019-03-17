import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min )
    {
	this.min = min;
	currentSize = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
		this.min = min;
		
		// COMPLETEZ
		// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
		
		//on copie le tableau donnee
		array = (AnyType[]) new Comparable[items.length];
		
		//array = items;
		
		for(int i =1; i<items.length; i++) {
			array[i] = items[i];
		}
		
		if(min == true) {
			buildMinHeap();
		}
		else {
			buildMaxHeap();
		}
    }
    
    public boolean offer( AnyType x )
    {
	if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	if( currentSize + 1 == array.length )
	    doubleArray();
	
	// COMPLETEZ
	//des notes de cours:
	int hole = ++currentSize;
	if( min == true) {
		
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2) {
			array[ hole ] = array[ hole / 2 ];
		}
		array[ hole ] = x;
	}
	else {//Cas max
		
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) > 0; hole /= 2) {
			array[ hole ] = array[ hole / 2 ];
		}
		array[ hole ] = x;
	}

	modifications++;
	
	return true;
    }
    
    public AnyType peek()
    {
	if(!isEmpty())
	    return array[1];
	
	return null;
    }
    
    public AnyType poll()
    {
	//COMPLETEZ

		AnyType tmpItem = array[ 1 ]; // Retire la racine
		array[ 1 ] = array[ currentSize-- ];
		if(min == true)
			percolateDownMinHeap(1,currentSize) ;
		else 
			percolateDownMaxHeap(1,currentSize);
		return tmpItem;
    }
    
    public Iterator<AnyType> iterator()
    {
	return new HeapIterator();
    }
    
    private void buildMinHeap()
    {
	//COMPLETEZ
    	//on n'est pas sur si on donne les bonnes param√®tres √† la fonction
    	for(int i=currentSize/2;i >0; i--) {
    		percolateDownMinHeap(i, array.length-1);
    	}
    }
    
    private void buildMaxHeap()
    {
	//COMPLETEZ
    	//on n'est pas sur si on donne les bonnes param√®tres √† la fonction
    	for(int i=currentSize/2;i >0; i--) {
    		percolateDownMaxHeap(i, array.length-1);
    	}
    }
    
    public boolean isEmpty()
    {
	return currentSize == 0;
    }
    
    public int size()
    {
	return currentSize;
    }
    
    public void clear()
    {
	currentSize = 0;
	modifications = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing )
    {
	return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 )
    {
	swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 )
    {
	AnyType tmp = array[ index1 ];
	array[ index1 ] = array[ index2 ];
	array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray()
    {
	AnyType [ ] newArray;
	
	newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size )
    {
	percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
    	if( heapIndexing == true) {
    		int child;
    		AnyType tmp;
    		for( tmp = array[ hole ]; leftChild( hole, true ) < size; hole = child ) {
    			
    			child = leftChild( hole , true);
    			
    			if(child > size)
    				break;
    			
	    		if( child != size - 1 && array[ child ].compareTo( array[ child + 1 ] ) > 0 )
	    			child++;
	    		if( tmp.compareTo( array[ child ] ) > 0 ) //Haut moins bas
	    			array[ hole ] = array[ child ];
	    		else {
	    			break;
	    		}
	    	}
    		array[ hole ] = tmp;
    	}
    	else {
    		//n'est pas demand√©
    	}
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size )
    {
	percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
    	if( heapIndexing == true) {
    		int child;
    		AnyType tmp;
    		for( tmp = array[ hole ]; leftChild( hole, true ) < size; hole = child ) {
    			child = leftChild( hole , true);
    			
    			if(child > size)
    				break;
    			
	    		if( child != size - 1 && array[ child ].compareTo( array[ child + 1 ] ) < 0 )
	    			child++;
	    		if( tmp.compareTo( array[ child ] ) < 0 ) //Haut moins bas
	    			array[ hole ] = array[ child ];
	    		else {
	    			break;
	    		}
	    	}
    		array[ hole ] = tmp;
    	}
    	else {
    		//n'est pas demand√©
    	}
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
	//COMPLETEZ

	//pour s'assurer que c'est construit.
		//buildMaxHeap(); [KC] : Pas besoin de vÈrifier puisque lorsqu'il est construit cette fonction est appelÈe 
		for(int i=a.length-1;i>0; i--){
			
			swapReferences( a, 0, i ); //est-ce que cette fonction existe et si oui est-ce qu'on a besoin de la faire?
			//et est-ce qu'elle fait la bonne chose?

			percolateDownMaxHeap(a,0,i,true); // Ajout de true
		}
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
		//pour s'assurer que c'est construit.
		//buildMinHeap(); [KC] : Pas besoin de vÈrifier puisque lorsqu'il est construit cette fonction est appelÈe 
		for(int i=a.length-1;i>0; i--){
			
			swapReferences( a, 0, i ); //est-ce que cette fonction existe et si oui est-ce qu'on a besoin de la faire?
			//et est-ce qu'elle fait la bonne chose?

			percolateDownMinHeap(a,0,i,true); // Ajout de true
		}
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";
	
	//COMPLETEZ

	return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
		    _prefix += "|  "; // un | et trois espace
		else
		    _prefix += "   " ; // quatre espaces
		
		if( !isLeaf ) {
		    outputString += printFancyTree( 2*index, _prefix);
		    outputString += printFancyTree( 2*index + 1, _prefix);
		}
	    }
	else
	    outputString += "null\n";
	
	return outputString;
    }
    
    private class HeapIterator implements Iterator {
	private int expectedModCount = modifications;
	private int iteratorCurrentPos = 1; // Car on commence toujours ‡ 1
	
	public boolean hasNext() {
		if(iteratorCurrentPos >= currentSize){
			return false;
		}
		else{
			return true;
		}
	}

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
	    //COMPLETEZ
		//pas sur car je l'ai √©crit sans eclipse.
		if(expectedModCount != modifications)
			throw new ConcurrentModificationException(); // Si il y a eu une modification 
		if(!hasNext()) 
            throw new java.util.NoSuchElementException(); // Si n'a pas d'autre element
        else
			return array[iteratorCurrentPos++];
		
		
	}
	
	//est-ce qu'on doit implementer cette fonction ? car c'est pas √©crit qu'on doit...
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
