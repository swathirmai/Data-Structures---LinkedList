package LinkedList;

public class RemoveLinkedListElements {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {
		RemoveLinkedListElements list = new RemoveLinkedListElements();
		// Creating a linked list
		Node head=new Node(5);
		list.addLast(head);
		list.addLast(new Node(6));
		list.addLast(new Node(7));
		list.addLast(new Node(1));
		list.addLast(new Node(2));
 
		//list.displayData(head);
		Node n = removeElements(head,6);
		while(n != null) {
			System.out.println(n.data);
			n=n.next;
		}

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

	public void deleteNode(Node node) {

		if (node.next == null) {
			node = null;
		}
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public static Node removeElements(Node head, int val) {
		Node sentinel = new Node(0);
		sentinel.next = head;

		Node prev = sentinel, curr = head;
		while (curr != null) {
			if (curr.data == val)
				prev.next = curr.next;
			else
				prev = curr;
				curr = curr.next;
		}
		return sentinel.next;
	}

	public Node deleteDuplicates(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			if (current.next.data == current.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static Node removeNthFromEnd(Node head, int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node first = dummy;
		Node second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}
