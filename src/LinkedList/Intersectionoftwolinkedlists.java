package LinkedList;

public class Intersectionoftwolinkedlists {

	private Node head;

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


	public Node findIntersectionNode(Node list1, Node list2) {

		int len1 = 0;
		int len2 = 0;
		Node p1 = list1, p2 = list2;
		if (p1 == null || p2 == null)
			return null;
		// Find the length of both linked list
		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}

		int diff = 0;
		p1 = list1;
		p2 = list2;
		// Find bigger linked list and iterate upto the different between two linked list.
		if (len1 > len2) {
			diff = len1 - len2;
			int i = 0;
			while (i < diff) {
				p1 = p1.next;
				i++;
			}
		} else {
			diff = len2 - len1;
			int i = 0;
			while (i < diff) {
				p2 = p2.next;
				i++;
			}
		}
		// Iterate over both linked list and find the common node
		while (p1 != null && p2 != null) {
			if (p1.value == p2.value) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		return null;
	}

	public static void main(String[] args) {
		Intersectionoftwolinkedlists list1 = new Intersectionoftwolinkedlists();
		// Creating a linked list
		Node head1=new Node(5);
		list1.addToTheLast(head1);
		list1.addToTheLast(new Node(6));
		Node node = new Node(7);
		list1.addToTheLast(node);
		//list1.addToTheLast(new Node(1));
		//list1.addToTheLast(new Node(2));

		Intersectionoftwolinkedlists list2 = new Intersectionoftwolinkedlists();
		Node head2=new Node(4);
		list2.addToTheLast(head2);
		list2.addToTheLast(node);
		list1.addToTheLast(new Node(8));
		list1.addToTheLast(new Node(2));

		Node findIntersectionNode = list1.findIntersectionNode(head1, head2);
		if(findIntersectionNode==null)
		{
			System.out.println("Two linked lists do not intersect!!");
		}
		else
		{
			System.out.println("Intersecting node: "+findIntersectionNode.value);
		}
	}

}
