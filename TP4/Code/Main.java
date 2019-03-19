import java.util.*;

public class Main {
	/**
	 * Fonction principale
	 */
	public static void main(String[] args) {
		// creer un monceau avec 22 elements et un tableau equivalent
		int numItems = 22;
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);

		Integer[] items = new Integer[numItems];

		int i;
		int j;

		// en inserant les elements un a un
		for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
			heap.offer(i);
			items[j] = i;

			i %= numItems;
		}

		// en construisant le monceau depuis le depart
		System.out.println("Monceau min contruit element par element:");
		System.out.println(heap.printFancyTree());

		heap = new BinaryHeap<Integer>(false);
		// en inserant les elements un a un
		for (Integer item : items)
			heap.offer(item);

		// en construisant le monceau depuis le depart
		System.out.println("Monceau max contruit element par element:");
		System.out.println(heap.printFancyTree());

		heap = new BinaryHeap<Integer>(items, false);
		System.out.println("Monceau max contruit a partir d'un tableau:");
		System.out.println(heap.printFancyTree());

		heap = new BinaryHeap<Integer>(items, true);
		System.out.println("Monceau min contruit a partir d'un tableau:");
		System.out.println(heap.printFancyTree());

		System.out.println();
		System.out.println("Affichage recursif:");
		System.out.println(heap.printFancyTree());

		System.out.println("Affichage non recursif:");
		System.out.println(heap.nonRecursivePrintFancyTree());

		System.out.println();
		System.out.println("Tableau d'origine:");
		System.out.println(printArray(items));

		BinaryHeap.heapSort(items);
		System.out.println("Tableau ordonne:");
		System.out.println(printArray(items));

		BinaryHeap.heapSortReverse(items);
		System.out.println("Tableau inversement ordonne:");
		System.out.println(printArray(items));

		/*
		 * Ajouter appels pour repondre a la question
		 **/
		
		System.out.println("\n---------- Start of tests ----------");
		testMinHeapPool(items);
		testMaxHeapPool(items);
		testMinHeapOffer(items);
		testMaxHeapOffer(items);
		
		try {testPollWhileIteration(items);}
		catch(Exception e) {System.out.print("Succeeded\n");}
		
		try {testOfferWhileIteration(items);}
		catch(Exception e) {System.out.print("Succeeded\n");}
		
		try {testOutOfBondIterator(items);}
		catch(Exception e) {System.out.print("Succeeded\n");}
		
		try {testIteratorRemove(items);}
		catch(Exception e) {System.out.print("Succeeded\n");}
		
		testSortedArray();
		testReverseSortedArray();
		testPrintFancyTree();
	}// main's end

	private static <AnyType> String printArray(AnyType[] a) {
		String outputString = "";

		for (AnyType item : a) {
			outputString += item;
			outputString += ", ";
		}

		return outputString.substring(0, outputString.length() - 2);
	}

	private static void testMinHeapPool(Integer[] items) {
		System.out.print("Testing : pool() w/ minHeap => ");
		int wantedValue = items[0];
		for (int itemValue : items) {// FindMin
			if (itemValue < wantedValue)
				wantedValue = itemValue;
		}
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		int minItem = testHeap.poll();
		System.out.println((minItem == wantedValue) ? "Succeeded" : "Failed" + "\n\t" + "Wanted Value: " + wantedValue + " Current Value : " + minItem + "\n");
	};

	private static void testMinHeapOffer(Integer[] items) {
		
		System.out.print("Testing : offer() w/ minHeap => ");
		int wantedValue = -1;
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		testHeap.offer(wantedValue);
		int minItem = testHeap.poll(); 
		System.out.println((minItem == wantedValue) ? "Succeeded" : "Failed" + "\n\t" + "Wanted Value: " + wantedValue + " Current Value : " + minItem + "\n");
	};

	private static void testMaxHeapPool(Integer[] items) {
		System.out.print("Testing : pool() /w maxHeap => ");
		int wantedValue = -100;
		for (int itemValue : items) {// FindMin
			if (itemValue > wantedValue)
				wantedValue = itemValue;
		}
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, false);
		int maxItem = testHeap.poll();
		System.out.println((maxItem == wantedValue) ? "Succeeded" : "Failed" + "\n\t" + "Wanted Value: " + wantedValue + " Current Value : " + maxItem + "\n");
	};
	
	private static void testMaxHeapOffer(Integer[] items) {
		System.out.print("Testing : offer() w/ maxHeap => ");
		int wantedValue = 10000;
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, false);
		testHeap.offer(wantedValue);
		int maxItem = testHeap.poll();
		System.out.println((maxItem == wantedValue) ? "Succeeded" : "Failed" + "\n\t" + "Wanted Value: " + wantedValue + " Current Value : " + maxItem + "\n");
	};
	
	private static void testPollWhileIteration(Integer[] items) {
		System.out.print("Testing : next() w/ poll() modifications  while iteration => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		testHeap.poll();
		it.next();
		System.out.print("Failed\n");
	}

	private static void testOfferWhileIteration(Integer[] items) {
		System.out.print("Testing : next() w/ offer() modifications while iteration => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		testHeap.offer(1);
		it.next();
		System.out.print("Failed\n");
	}
	
	private static void testOutOfBondIterator(Integer[] items) {
		System.out.print("Testing : next() w/ out of bound iterator => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		for(int i = 0 ; i <= items.length; i++ )
			it.next();
		System.out.print("Failed\n");
	};

	private static void testIteratorRemove(Integer[] items) {
		System.out.print("Testing : remove() w/ iterator => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		it.remove();
	};

	private static void testSortedArray() {
		System.out.print("Testing : heapSort() => ");
		
		Integer [] answer = new Integer[] {11, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 56, 57, 58};
		Integer[] testItem = new Integer[] {11, 48, 41, 56, 49, 42, 57, 50, 43, 58, 51, 44, 37, 52, 45, 38, 53, 46, 39, 54, 47, 40}; // Tableau d'origine
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(testItem, true);
		
		testHeap.heapSort(testItem);
		for(int i = 0; i < answer.length; i++) {
			if(testItem[i] != answer[i]) {
				System.out.println("Failed");
				System.out.println("\t" + "Wrong element at index : " + i);
				System.out.println("\t" + "Expected Value : " + answer[i] + " Current Value : " + testItem[i]);
				return;
			}//if
		}//for
		System.out.println("Succeeded");
	};
	
	private static void testReverseSortedArray() {
		System.out.print("Testing : heapSortReverse() => ");
		
		Integer [] answer = new Integer[] {58, 57, 56, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 11};
		Integer[] testItem = new Integer[] {11, 48, 41, 56, 49, 42, 57, 50, 43, 58, 51, 44, 37, 52, 45, 38, 53, 46, 39, 54, 47, 40}; // Tableau d'origine
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(testItem, true);
		
		testHeap.heapSortReverse(testItem);
		for(int i = 0; i < answer.length; i++) {
			if(testItem[i] != answer[i]) {
				System.out.println("Failed");
				System.out.println("\t" + "Wrong element at index : " + i);
				System.out.println("\t" + "Expected Value : " + answer[i] + " Current Value : " + testItem[i]);
				return;
			}//if
		}//for
		System.out.println("Succeeded");
	};
	
	private static void testPrintFancyTree() {
		System.out.print("Testing : printFancyTree() minHeap w/ elem by elem  => ");
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
		int numItems = 22; 
		Integer[] items = new Integer[numItems];

		int i;
		int j;

		// en inserant les elements un a un
		for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
			heap.offer(i);
			items[j] = i;

			i %= numItems;
		}
		String[] answer  = new String[] { //Elem par elem minheap
				"|__11\n" + 
				"   |__38\n" + 
				"   |  |__39\n" + 
				"   |  |  |__48\n" + 
				"   |  |  |  |__56\n" + 
				"   |  |  |  |__53\n" + 
				"   |  |  |__43\n" + 
				"   |  |     |__50\n" + 
				"   |  |     |__46\n" + 
				"   |  |__40\n" + 
				"   |     |__49\n" + 
				"   |     |  |__58\n" + 
				"   |     |  |__54\n" + 
				"   |     |__47\n" + 
				"   |        |__51\n" + 
				"   |        |__null\n" + 
				"   |__37\n" + 
				"      |__41\n" + 
				"      |  |__44\n" + 
				"      |  |__42\n" + 
				"      |__45\n" + 
				"         |__57\n" + 
				"         |__52\n"};
		String [] outputString = new String[] {heap.printFancyTree()};
		boolean succes = true;
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(answer[0]) != 0) {
				succes = false;
				break;
			}//if
		}//for
		System.out.println((succes)? "Succeeded" : "Failed");
		succes = true;
		System.out.print("Testing : printFancyTree() maxHeap w/ elem by elem  => ");
		heap = new BinaryHeap<Integer>(false);
		// en inserant les elements un a un
		for (Integer item : items)
			heap.offer(item);
		answer = new String[] { // elem par elem maxheap
				"|__58\n" + 
				"   |__57\n" + 
				"   |  |__53\n" + 
				"   |  |  |__49\n" + 
				"   |  |  |  |__11\n" + 
				"   |  |  |  |__38\n" + 
				"   |  |  |__46\n" + 
				"   |  |     |__43\n" + 
				"   |  |     |__39\n" + 
				"   |  |__54\n" + 
				"   |     |__51\n" + 
				"   |     |  |__48\n" + 
				"   |     |  |__47\n" + 
				"   |     |__50\n" + 
				"   |        |__40\n" + 
				"   |        |__null\n" + 
				"   |__56\n" + 
				"      |__44\n" + 
				"      |  |__41\n" + 
				"      |  |__37\n" + 
				"      |__52\n" + 
				"         |__42\n" + 
				"         |__45\n"};
		outputString = new String[] {heap.printFancyTree()};
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(answer[0]) != 0) {
				succes = false;
				break;
			}//if
		}//for	
		System.out.println((succes)? "Succeeded" : "Failed");succes =true;
		
		System.out.print("Testing : printFancyTree() maxHeap w/ from array  => ");
		heap = new BinaryHeap<Integer>(items, false);
		answer = new String []{
				"|__58\n" + 
				"   |__56\n" + 
				"   |  |__53\n" + 
				"   |  |  |__50\n" + 
				"   |  |  |  |__38\n" + 
				"   |  |  |  |__11\n" + 
				"   |  |  |__46\n" + 
				"   |  |     |__43\n" + 
				"   |  |     |__39\n" + 
				"   |  |__54\n" + 
				"   |     |__49\n" + 
				"   |     |  |__48\n" + 
				"   |     |  |__47\n" + 
				"   |     |__51\n" + 
				"   |        |__40\n" + 
				"   |        |__null\n" + 
				"   |__57\n" + 
				"      |__44\n" + 
				"      |  |__42\n" + 
				"      |  |__37\n" + 
				"      |__52\n" + 
				"         |__41\n" + 
				"         |__45\n" };
		
		System.out.println((succes)? "Succeeded" : "Failed");succes =true;
		outputString = new String[] {heap.printFancyTree()};
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(answer[0]) != 0) {
				succes = false;
				break;
			}
		}
		System.out.print("Testing : printFancyTree() minHeap w/ from array  => ");
		
		heap = new BinaryHeap<Integer>(items, true);
		answer = new String[] {
		"|__11\n" + 
		"   |__38\n" + 
		"   |  |__39\n" + 
		"   |  |  |__50\n" + 
		"   |  |  |  |__56\n" + 
		"   |  |  |  |__53\n" + 
		"   |  |  |__43\n" + 
		"   |  |     |__46\n" + 
		"   |  |     |__48\n" + 
		"   |  |__40\n" + 
		"   |     |__47\n" + 
		"   |     |  |__54\n" + 
		"   |     |  |__58\n" + 
		"   |     |__49\n" + 
		"   |        |__51\n" + 
		"   |        |__null\n" + 
		"   |__37\n" + 
		"      |__41\n" + 
		"      |  |__44\n" + 
		"      |  |__42\n" + 
		"      |__45\n" + 
		"         |__52\n" + 
		"         |__57\n"};
		outputString = new String[] {heap.printFancyTree()};
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(answer[0]) != 0) {
				succes = false;
				break;
			}
		}
		System.out.println((succes)? "Succeeded" : "Failed");succes = true;
		
		System.out.print("Testing : nonRecursivePrintFancyTree() minHeap w/ from array  => ");
		
		outputString = new String[] {heap.nonRecursivePrintFancyTree()};
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(answer[0]) != 0) {
				succes = false;
				break;
			}
		}
		System.out.println((succes)? "Succeeded" : "Failed");succes =true;
	};//testPrintFancyTree
	
}//main
