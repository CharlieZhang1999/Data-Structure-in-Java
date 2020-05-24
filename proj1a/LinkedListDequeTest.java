/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}



	public static void main(String[] args) {
		/*System.out.println("Running tests.\n");
		addIsEmptySizeTest();*/
		ArraygetTest();
	}

	public static void LinkedListtest(){
		LinkedListDeque<Integer> ad = new LinkedListDeque<Integer>();
		ad.addFirst(0);
		ad.addFirst(1);
		ad.addFirst(2);
		System.out.println(ad.get(1));

	}
	public static void ArrayremoveandaddTest(){
		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}
	public static void ArraygetTest(){
		ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
		ArrayDeque.addLast(0);
		ArrayDeque.addFirst(1);
		ArrayDeque.removeFirst();
		ArrayDeque.addFirst(3);
		ArrayDeque.addLast(4);
		System.out.println(ArrayDeque.removeFirst());
		ArrayDeque.addFirst(6);
		System.out.println(ArrayDeque.removeLast());
		ArrayDeque.addFirst(8);
		ArrayDeque.addFirst(9);
		ArrayDeque.addFirst(10);
		ArrayDeque.addLast(11);
		ArrayDeque.addLast(12);
		System.out.println(ArrayDeque.get(1));    // ==> 9
		ArrayDeque.addFirst(14);
		System.out.println(ArrayDeque.get(1));    // ==> 10
		System.out.println(ArrayDeque.removeFirst());//    ==> 14
		ArrayDeque.addLast(17);
		ArrayDeque.addFirst(18);
		ArrayDeque.addLast(19);
		System.out.println(ArrayDeque.removeFirst());//     ==> 18
		System.out.println(ArrayDeque.removeFirst());//     ==> 17
	}
	public static void Arraytest(){
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		ad.addFirst(0);
		ad.addFirst(1);
		ad.addFirst(2);
		ad.addFirst(3);
		ad.addFirst(4);
		ad.addFirst(5);
		ad.addFirst(6);
		ad.addFirst(7);
		ad.addFirst(8);
		ad.addFirst(9);
		ad.printDeque();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.removeFirst();
		ad.addFirst(0);
		ad.addFirst(1);
		ad.addFirst(2);
		ad.addFirst(3);
		System.out.println("the new deque");
		ad.printDeque();

		//System.out.println(ad.removeLast());*/



	}
} 