package linkedList;

import java.util.Currency;
import java.util.Scanner;

public class LinkedListPractice {

	public LinkedListPractice() {
		// TODO Auto-generated constructor stub
	}

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number to generate linked list.");
		LinkedListNode<Integer> head = createLinkedList();
		System.out.println("Your liked list is");
		printLinkedListIterative(head);
		System.out.println("Recursive printing.");
		printLinkedListRecursive(head);
		int middle = findMiddleIndexIterative(head);
		System.out.println("\nMiddle index is " + middle);
		int length = findLengthRecursive(head, 0);
		System.out.println("Length of linked list is " + length);
		System.out.println("Enter position and data to insert in linked list");
//		int position = scanner.nextInt();
//		int data = scanner.nextInt();
//		LinkedListNode<Integer> updatedHeadI = insertI(head, data, position);
//		System.out.println("After insertion Iterative");
//		printLinkedListRecursive(updatedHeadI);
//		System.out.println("\nRECURSIVE METHOD");
//		LinkedListNode<Integer> updatedHeadR = insertR2(head, data, position);
//		System.out.println("\nAfter insertion Recursive");
//		printLinkedListRecursive(updatedHeadR);
//		System.out.println();
//		LinkedListNode<Integer> deletedHeadR = deleteNodeRecursive(head, position);
//		printLinkedListRecursive(deletedHeadR);
//		LinkedListNode<Integer> reveresedI =  reverseIterative(head);
//		printLinkedListIterative(reveresedI);
//		int positionSwap = scanner.nextInt();
//		LinkedListNode<Integer> swaped = swapNodesWithpositions(head, position, positionSwap);
//		printLinkedListRecursive(swaped);
//		LinkedListNode<Integer> swapOptimized = swapOptimized(head, position, positionSwap);
//		System.out.println("AFTER SWAPED");
//		printLinkedListRecursive(swapOptimized);
//		LinkedListNode<Integer> swapOptimizedFinal = swapOptimizedFinal(head, position, positionSwap);
//		System.out.println("AFTER SWAPED");
//		printLinkedListRecursive(swapOptimizedFinal);
//		LinkedListNode<Integer> reversedI =  reverseIterative(head);
//		printLinkedListRecursive(reversedI);
//		System.out.println();
		Boolean isPalindrom = isPalindrome(head);
		System.out.println("Is Palindrom : "+ isPalindrom);
	}
	
	

	private static Boolean isPalindrome(LinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
	    // 1. Reverse LL tile Middle.
		// 2. Compare both half LLs.
		LinkedListNode<Integer> middle = findMiddleIterative(head);
		System.out.println("Middle is : "+ middle.data);
		return true;
	}



	public static LinkedListNode<Integer> swapOptimizedFinal(LinkedListNode<Integer> head, int position,
			int positionSwap) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> previousFirst = null;
		LinkedListNode<Integer> currentFirst = head;
		LinkedListNode<Integer> previousSecond = null;
		LinkedListNode<Integer> currentSecond = head;
		for (int i = 0; i < position; i++) {
			previousFirst = currentFirst;
			currentFirst = currentFirst.next;
		}

		for (int i = 0; i < positionSwap; i++) {
			previousSecond = currentSecond;
			currentSecond = currentSecond.next;
		}
		if(previousFirst == null) {
			head = currentSecond;
		} else {
			previousFirst.next = currentSecond;
		}
		LinkedListNode<Integer> temp = currentSecond.next;
		if(previousSecond != currentFirst) {
			currentSecond.next = currentFirst.next;
		} else {
			currentSecond.next = currentFirst;
		}
		if(previousSecond == null) {
			head = currentFirst;
		} else {
			previousSecond.next = currentFirst;
		}
		currentFirst.next = temp;
		return head;
	}

    

	public static LinkedListNode<Integer> swapOptimized(LinkedListNode<Integer> head, int position, int positionSwap) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> previousFirst = null;
		LinkedListNode<Integer> currentFirst = head;
		LinkedListNode<Integer> previousSecond = null;
		LinkedListNode<Integer> currentSecond = head;
		for (int i = 0; i < position; i++) {
			previousFirst = currentFirst;
			currentFirst = currentFirst.next;
		}

		for (int i = 0; i < positionSwap; i++) {
			previousSecond = currentSecond;
			currentSecond = currentSecond.next;
		}
		System.out.println("First " + currentFirst.data + " " + previousFirst);
		System.out.println("Second " + currentSecond.data + " " + previousSecond.data);
		//
//	  + " "+ previousSecond.data
		LinkedListNode<Integer> temp = currentSecond.next;

//		printLinkedListIterative(currentFirst);
//		System.out.println();
//		printLinkedListIterative(previousFirst);
//	    System.out.println();
//		printLinkedListIterative(currentSecond);
//		System.out.println();
//		printLinkedListIterative(previousSecond);
//	  previousSecond.next = currentFirst;
//	  if(previousFirst == null) {
//		 head = currentSecond
//	  }
		if (position == 0 || positionSwap == 0) {
			if(Math.abs(positionSwap - position) == 1) {
				System.out.println("3rd");
			} else {
				System.out.println("1st");
//				previousFirst = currentSecond;

				currentFirst.next = currentSecond.next;
				previousSecond.next = currentFirst;
				currentSecond.next = previousSecond;
			}
//			previousFirst.next = currentSecond;
//			previousSecond.next = currentFirst;
//			currentFirst.next = currentSecond.next;
//			currentSecond.next = previousSecond;		
		} else if (Math.abs(positionSwap - position) == 1) {
			System.out.println("2nd");
		}  else {
			System.out.println("4th");
//			previousFirst.next = currentSecond;
//			previousSecond.next = currentFirst;
//			currentFirst.next = currentSecond.next;
//			currentSecond.next = previousSecond;
		}

		return head;
	}

	public static LinkedListNode<Integer> swapNodesWithpositions(LinkedListNode<Integer> head, int position,
			int positionSwap) {
		LinkedListNode<Integer> first = new LinkedListNode<>(-1);
		LinkedListNode<Integer> second = new LinkedListNode<>(-1);
		LinkedListNode<Integer> iterator = head;
		int length = findLengthRecursive(head, 0);
		for (int i = 0; i < length; i++) {
			if (i == position) {
				first = iterator;
			}
			if (i == positionSwap) {
				second = iterator;
			}
			iterator = iterator.next;
		}
		head = deleteNodeRecursive(head, position);
		head = insertR(head, second.data, position);
		head = deleteNodeRecursive(head, positionSwap);
		head = insertR(head, first.data, positionSwap);
		return head;
	}

	public static LinkedListNode<Integer> reverseIterative(LinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		if(head == null && head.next == null ) {
			return head;
		}
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			LinkedListNode<Integer> next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next; 
		}
		return prev;
	}

	public static LinkedListNode<Integer> insertR(LinkedListNode<Integer> head, int data, int pos) {
		if (head == null) {
			return head;
		}
		LinkedListNode<Integer> insertedNode = new LinkedListNode<>(data);
		if (pos == 0) {
			LinkedListNode<Integer> forward = head;
			head = insertedNode;
			insertedNode.next = forward;
			return head;
		}
		if (pos == 1) {
			insertedNode.next = head.next;
			head.next = insertedNode;
			return head;
		}

		insertR(head.next, data, pos - 1);
		return head;
	}

	public static LinkedListNode<Integer> insertR2(LinkedListNode<Integer> head, int data, int pos) {
		if (head == null && pos > 0) {
			return head;
		}
		if (pos == 0) {
			LinkedListNode<Integer> insertedNode = new LinkedListNode<>(data);
			insertedNode.next = head;
			head = insertedNode;
			return head;
		}

		LinkedListNode<Integer> next = insertR2(head.next, data, pos - 1);
		head.next = next;
		return head;
	}

	public static LinkedListNode<Integer> deleteNodeRecursive(LinkedListNode<Integer> head, int pos) {
		if (head == null && pos > 0) {
			return head;
		}
		if (pos == 0) {
			head = head.next;
			return head;
		}
		LinkedListNode<Integer> recursiveNode = deleteNodeRecursive(head.next, pos - 1);
		head.next = recursiveNode;
		return head;
	}

	public static LinkedListNode<Integer> insertI(LinkedListNode<Integer> head, int data, int pos) {

		if (head == null) {
			return head;
		}
		LinkedListNode<Integer> insertedNode = new LinkedListNode<>(data);
		LinkedListNode<Integer> current = head;
		if (pos == 0) {
			LinkedListNode<Integer> forward = head;
			head = insertedNode;
			insertedNode.next = forward;
			return head;
		}
		int count = 1;
		while (count != pos) {
//			System.out.println("Current element is " + current.data);
			if (current == null) {
				return head;
			}
			current = current.next;
			count++;
		}
//		System.out.println("Current element at given position is " + current.data);
		LinkedListNode<Integer> forward = current.next;
		current.next = insertedNode;
		insertedNode.next = forward;
//		forward.next = insertedNode.next;
//		System.out.println("Forward node is "+ forward.data);
		return head;

	}

	public static int findLengthRecursive(LinkedListNode<Integer> head, int length) {
		if (head == null) {
			return length;
		}
		length++;
		return findLengthRecursive(head.next, length);
	}

	public static int findMiddleIndexIterative(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = null;
		int length = findLengthRecursive(head, 0);
		int ans = 0;
		if (length % 2 == 0) {
			fast = head;
		} else {
			fast = head.next;
		}
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			ans++;
		}
		return ans;
	}
	public static LinkedListNode<Integer> findMiddleIterative(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = null;
		int length = findLengthRecursive(head, 1);
		if (length % 2 == 0) {
			fast = head;
		} else {
			fast = head.next;
		}
		fast = fast.next;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Slow "+ slow.data);
		return slow;
	}

	public static void printLinkedListIterative(LinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		System.out.println("Iterative printing.");
		if (head == null) {
			return;
		}
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printLinkedListRecursive(LinkedListNode<Integer> head) {

		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printLinkedListRecursive(head.next);
	}

	public static LinkedListNode<Integer> createLinkedList() {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		int data = scanner.nextInt();
		while (data != -1) {
			LinkedListNode<Integer> llnode = new LinkedListNode<>(data);
			if (head == null) {
				head = llnode;
				tail = llnode;
			} else {
				tail.next = llnode;
				tail = tail.next;
			}
			data = scanner.nextInt();
		}

		return head;
	}
}
