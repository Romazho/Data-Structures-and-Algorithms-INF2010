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
		System.out.print("Testing : pool() /w minHeap => ");
		int wantedValue = 100;
		for (int itemValue : items) {// FindMin
			if (itemValue < wantedValue)
				wantedValue = itemValue;
		}
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		int minItem = testHeap.poll();
		String testResult = (minItem == wantedValue) ? "Succeeded" : "Failed";
		System.out.println(testResult);
		System.out.println("\t" + "Wanted Value: " + wantedValue + " Current Value : " + minItem + "\n");
	};

	private static void testMinHeapOffer(Integer[] items) {
		
		System.out.print("Testing : offer() /w minHeap => ");
		int wantedValue = -1;
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		testHeap.offer(wantedValue);
		int minItem = testHeap.poll();
		String testResult = (minItem == wantedValue) ? "Succeeded" : "Failed";
		System.out.println(testResult);
		System.out.println("\t" + "Wanted Value: " + wantedValue + " Current Value : " + minItem + "\n");
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
		String testResult = (maxItem == wantedValue) ? "Succeeded" : "Failed";
		System.out.println(testResult);
		System.out.println("\t" + "Wanted Value: " + wantedValue + " Current Value : " + maxItem + "\n");
	};
	private static void testMaxHeapOffer(Integer[] items) {
		System.out.print("Testing : offer() /w maxHeap => ");
		int wantedValue = 10000;
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, false);
		testHeap.offer(wantedValue);
		int maxItem = testHeap.poll();
		String testResult = (maxItem == wantedValue) ? "Succeeded" : "Failed";
		System.out.println(testResult);
		System.out.println("\t" + "Wanted Value: " + wantedValue + " Current Value : " + maxItem + "\n");
	};
	
	private static void testPollWhileIteration(Integer[] items) {
		System.out.print("Testing : next() /w poll() modifications  while iteration => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		testHeap.poll();
		it.next();
		System.out.print("Failed\n");
	}
	private static void testOfferWhileIteration(Integer[] items) {
		System.out.print("Testing : next() /w offer() modifications while iteration => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		testHeap.offer(1);
		it.next();
		System.out.print("Failed\n");
	}
	
	private static void testOutOfBondIterator(Integer[] items) {
		System.out.print("Testing : next() /w out of bound iterator => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		for(int i = 0 ; i <= items.length; i++ )
			it.next();
		System.out.print("Failed\n");
	};
	private static void testIteratorRemove(Integer[] items) {
		System.out.print("Testing : remove() /w iterator => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		Iterator<Integer> it = testHeap.iterator();
		it.remove();
	};
	private static void testSortedArray(Integer[] items) {
		System.out.print("Testing : heapSort() => ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true);
		testHeap.heapSort(items);
	};
}
