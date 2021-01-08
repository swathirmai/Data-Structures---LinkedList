package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class MergeTwoSortedLists {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {
		MergeTwoSortedLists list = new MergeTwoSortedLists();
		Node loopNode = new Node(7);
		list.addLast(new Node(5));
		list.addLast(new Node(6));
		list.addLast(loopNode);
		list.addLast(new Node(1));
		list.addLast(new Node(2));

		// list.printList();
		// creating a loop
		list.addLast(loopNode);

		// displayData(head);
		// System.out.println("Reverse List");
		// reverseList(head);
		// Node n = middle(head);
		// System.out.println(n.data);
		// System.out.println(loopDetect(head));
	}

	public static void addLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;

		}
	}

	public static void displayData(Node head) {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public Node mergeTwoLists(Node l1, Node l2) {
		Node head = new Node(0);
		Node p = head;

		Node p1 = l1;
		Node p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
	}
}
