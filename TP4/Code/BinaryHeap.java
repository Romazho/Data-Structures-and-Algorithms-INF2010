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
		currentSize = items.length;
		
		
		array = (AnyType[]) new Comparable[currentSize + 1]; // Allocation de la mémoire. +1 car on commence à l'index 1
		// Dans le livre il font quelque chose de bizarre ...
		int i = 1;
		for(AnyType item : items) { // Copie des éléments d'item(index 0) vers array (index 1)
			array[i++] = item;
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
		AnyType tmpItem = array[ 1 ]; // Retire la racine
		array[ 1 ] = array[ currentSize-- ];
		if(min == true) {
			percolateDownMinHeap(1,currentSize) ;
			modifications ++; // Bon endroit pour faire ça ? 
		}
		else {
			percolateDownMaxHeap(1,currentSize);
			modifications ++; // Bon endroit pour faire ça ? 
		}
		return tmpItem;
    }
    
    public Iterator<AnyType> iterator()
    {
	return new HeapIterator();
    }
    
    private void buildMinHeap()
    {
    	for(int i=currentSize/2;i >0; i--) {
    		percolateDownMinHeap(i, array.length);
    	}
    }
    
    private void buildMaxHeap()
    {
    	for(int i=currentSize/2;i >0; i--) {
    		percolateDownMaxHeap(i, array.length);
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
    		//n'est pas demandÃ©
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
    		//n'est pas demandÃ©
    	}
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
    	for( int i = a.length / 2 - 1; i >= 0; i-- ) /* buildHeap */
    		percolateDownMaxHeap( a, i, a.length,true);
    	
		for(int i=a.length-1;i>0; i--){
			swapReferences( a, 0, i ); 
			percolateDownMaxHeap(a,0,i,true); 
		}//for
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
       	for( int i = a.length / 2 - 1; i >= 0; i-- ) /* buildHeap car static */
       		percolateDownMinHeap( a, i, a.length,true);
  
		for(int i=a.length-1;i>0; i--){
			
			swapReferences( a, 0, i ); 
			percolateDownMinHeap(a,0,i,true);
		}//for
    }
    
    
    /*
     * Version adaptée de https://www.geeksforgeeks.org/iterative-preorder-traversal/
     */
    public String nonRecursivePrintFancyTree()
    {
    	int index = 1;
        if (array[index] == null) {    // S'il est vide, cas de base
            return " Is empty"; 
        } 
        String outputString = "";
        
        Stack<Integer> indexStack = new Stack<Integer>(); 
        Stack<String> spacingStack = new Stack<String>();
        
        boolean leafToNode = false;
        indexStack.push(index); 
        spacingStack.push(outputString);
  
        while (indexStack.empty() == false) { 
        	String spacing = spacingStack.peek();
        	index = indexStack.peek(); // Dernier item sur le stack
    
        	int leftIndex = leftChild(index, true);
        	int rightIndex = leftIndex + 1;
        	
        	if(leafToNode == true) { 
        		spacingStack.pop();
        		leafToNode = false;
        	}
        	outputString += spacing + "|__";
        	
        	if(index <= currentSize) {
        		boolean isLeaf = index > currentSize/2;
        		
	        	outputString += array[index]  + "\n";
	        	indexStack.pop(); 
	            
	    		if(index % 2 == 0) {
	    		    spacing += "|  "; 
	    		    spacingStack.push(spacing);
	    		}
	    		
	    		else {
	    		    spacing += "   " ;
	    		    spacingStack.push(spacing);
	    		}
	    		
	            if(!isLeaf){ 
	        	   indexStack.push(rightIndex); // Child_Droite
	        	   indexStack.push(leftIndex);  // Child_Gauche
	           }
	            else {
	            	spacingStack.pop();
	            	leafToNode = true;
	           
	            }
	        } //if
        	else {
        		outputString += "null\n";
        		indexStack.pop();
        	}
        	
        }//while
    
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
		
		if( index % 2 == 0 )
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
	private int iteratorCurrentPos = 1; // Car on commence toujours à 1
	
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
		if(expectedModCount != modifications)
			throw new ConcurrentModificationException("Heap has been modified while in iteration"); // Si il y a eu une modification 
		if(!hasNext()) 
            throw new NoSuchElementException("There is no more elements"); // Si n'a pas d'autre element
        else
			return array[iteratorCurrentPos++];
		
		
	}
	
	//est-ce qu'on doit implementer cette fonction ? car c'est pas Ã©crit qu'on doit...
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
