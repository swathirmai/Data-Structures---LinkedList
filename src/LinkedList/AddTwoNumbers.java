package LinkedList;

public class AddTwoNumbers {

	private static Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;

		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList(Node printNode) {
		Node temp = printNode;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node reverseLinkedList(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node remaining = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

	// This function will do sum of numbers represented by linked list
	public Node findSumOfNumbers(Node l1, Node l2) {
		Node fake = new Node(0);
		Node p = fake;

		Node p1 = l1;
		Node p2 = l2;

		int carry = 0;
		while (p1 != null || p2 != null) {
			int sum = carry;
			if (p1 != null) {
				sum += p1.value;
				p1 = p1.next;
			}

			if (p2 != null) {
				sum += p2.value;
				p2 = p2.next;
			}

			if (sum > 9) {
				carry = 1;
				sum = sum - 10;
			} else {
				carry = 0;
			}

			Node l = new Node(sum);
			p.next = l;
			p = p.next;
		}

		// don't forget check the carry value at the end
		if (carry > 0) {
			Node l = new Node(carry);
			p.next = l;
		}
		return fake.next;
	}


	public static void main(String[] args) {
		AddTwoNumbers list = new AddTwoNumbers();
		// Creating a linked list
		Node head1 = new Node(5);
		list.addToTheLast(head1);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		System.out.print("Number 1:  ");
		list.printList(head1);
		head = null;
		Node head2 = new Node(6);
		list.addToTheLast(head2);
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(5));
		list.addToTheLast(new Node(9));

		System.out.print("Number 2:  ");
		list.printList(head2);
		// Reversing first linkedList
		head1 = reverseLinkedList(head1);

		// Reversing second linkedList
		head2 = reverseLinkedList(head2);

		// function to find sum of two linkedlist represent by number
		Node result = list.findSumOfNumbers(head1, head2);
		// Reverse the above linkedlist to get actual sum
		result = reverseLinkedList(result);
		System.out.print("Sum:  ");
		list.printList(result);
	}
}
