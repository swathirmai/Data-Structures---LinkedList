package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import LinkedList.ReverseLinkedList.Node;

public class MergekSortedLists {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {
		MergekSortedLists list = new MergekSortedLists();
		// list 1 
		Node n1 = new Node(1); 
		n1.next = new Node(2); 
		n1.next.next = new Node(3); 
		n1.next.next.next = new Node(4); 
		n1.next.next.next.next = new Node(5); 
		n1.next.next.next.next.next = new Node(6); 
		n1.next.next.next.next.next.next = new Node(7); 
		// list 2 
		Node n2 = new Node(10); 
		n2.next = new Node(9); 
		n2.next.next = new Node(8); 
		n2.next.next.next = n1.next.next.next; 

		Node[] lists = new Node[2];
		lists[0] = n1;
		lists[1] = n2;

		Node n = mergeKLists(lists);
		System.out.println(n.data);
		//System.out.println(loopDetect(head));
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

	public static Node mergeKLists(Node[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node l1, Node l2) {
				return l1.data - l2.data;
			}
		});

		Node head = new Node(0);
		Node p = head;

		for (Node list : lists) {
			if (list != null)
				queue.offer(list);
		}

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			p.next = n;
			p = p.next;

			if (n.next != null)
				queue.offer(n.next);
		}

		return head.next;

	}
}
