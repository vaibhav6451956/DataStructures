package com.vaibhav.bigO;

public class BigO {

	private int[] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	static long startTime;
	static long endTime;

	public BigO(int size) {
		this.arraySize = size;
		theArray = new int[size];
	}

	public static void main(String args[]) {

		BigO o = new BigO(100000);
		o.generateRandomArray();

		BigO o1 = new BigO(200000);
		o.generateRandomArray();

		BigO o2 = new BigO(300000);
		o.generateRandomArray();

		BigO o3 = new BigO(400000);
		o.generateRandomArray();

		// Running linear search to find 20 in all above created arrays
		o.linearSearch(20);
		o1.linearSearch(20);
		o2.linearSearch(20);
		o3.linearSearch(20);

		// Running Quick Sort
		System.out.println("\n Running Quick Sort");
		startTime = System.currentTimeMillis();
		o3.quickSort(0, o.itemsInArray);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort took: " + (endTime - startTime));

		// Running Bubble Sort
		BigO o4 = new BigO(10000);
		o4.generateRandomArray();

		BigO o5 = new BigO(20000);
		o5.generateRandomArray();

		BigO o6 = new BigO(30000);
		o6.generateRandomArray();

		BigO o7 = new BigO(40000);
		o7.generateRandomArray();
		System.out.println("\n Running Bubble Sort");

		o4.bubbleSort();
		o5.bubbleSort();
		o6.bubbleSort();
		o7.bubbleSort();

		System.out.println("\n Running Binary Search");
		o4.binarySearchForValue(20);
		o5.binarySearchForValue(20);
		o6.binarySearchForValue(20);
		o7.binarySearchForValue(20);

	}

	// ==========================================
	// O(1) i.e. Runtime is constant irrespective of the input size
	// ADDING ITEM TO ARRAY
	// ==========================================

	public void addItemToArray(int newItem) {
		theArray[itemsInArray++] = newItem;
	}

	// ==========================================
	// (N) i.e. Runtime is directly proportional to the size of input
	// LINEAR SEARCH
	// ==========================================

	public void linearSearch(int valueToSearch) {

		boolean valueInArray = false;

		// There can be multiple appearances of same value so we will take note of all
		// of them
		String indexesWithValue = "";

		startTime = System.currentTimeMillis();

		for (int i = 0; i < arraySize; i++) {

			if (theArray[i] == valueToSearch) {
				valueInArray = true;
				indexesWithValue += i + " ";
			}
		}

		System.out.println("Value Found: " + valueInArray);
		endTime = System.currentTimeMillis();
		System.out.println("Linear Search took: " + (endTime - startTime));

	}

	// ==========================================
	// O(N^2) BUBBLE SORT
	// ==========================================

	public void bubbleSort() {
		startTime = System.currentTimeMillis();

		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {

				if (theArray[j] > theArray[j + 1]) {
					swapValues(j, j + 1);
				}
			}

		}

		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took: " + (endTime - startTime));

	}

	// ====================================================
	// O(log N) - When in each iteration the input size roughly halves
	// BINARY SEARCH
	// ===================================================

	public void binarySearchForValue(int value) {
		startTime = System.currentTimeMillis();

		int lowIndex = 0;
		int highIndex = arraySize - 1;
		int timesThrough = 0;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (theArray[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			} else if (theArray[middleIndex] > value) {
				highIndex = middleIndex - 1;
			} else {
				System.out.println("Found a match in index: " + middleIndex);
				lowIndex = highIndex + 1;
			}

			timesThrough++;

		}
		endTime = System.currentTimeMillis();
		System.out.println("Binary Search took: " + (endTime - startTime));
		System.out.println("Time Thorugh: " + timesThrough);

	}

	// ====================================================
	// O(nlog N)
	// QUICK SORT
	// ===================================================

	public void quickSort(int left, int right) {

		if (right - left <= 0)
			return;

		else {
			int pivot = theArray[right];
			int pivotLocation = partitionArray(left, right, pivot);
			quickSort(left, pivotLocation - 1);
			quickSort(pivotLocation + 1, right);
		}
	}

	public int partitionArray(int left, int right, int pivot) {

		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {

			while (theArray[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer) {

				break;

			} else {

				swapValues(leftPointer, rightPointer);

			}

		}

		swapValues(leftPointer, right);

		return leftPointer;

	}

	/*
	 * ==========================================
	 * 
	 * HELPER METHODS BELOW
	 * 
	 * ==========================================
	 */

	// Method to generate a random array
	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 1000) + 10;
		}

		itemsInArray = arraySize - 1;
	}

	// Method to swap values
	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];

		theArray[indexTwo] = temp;

	}

}
