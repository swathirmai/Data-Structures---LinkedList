package LinkedList;

public class ReverseLinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		Node loopNode=new Node(7);
		list.addLast(new Node(5));
		list.addLast(new Node(6));
		list.addLast(loopNode);
		list.addLast(new Node(1));
		list.addLast(new Node(2));
 
		//list.printList();
		// creating a loop
		list.addLast(loopNode);

		//displayData(head);
		//System.out.println("Reverse List");
		//reverseList(head);
		//Node n = middle(head);
		//System.out.println(n.data);
		System.out.println(loopDetect(head));
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

	public static void reverseList(Node head) {
		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}

		//displayData(prev);
	}
	
	public static Node middle(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null) {
			fast = fast.next;
			if(fast != null && fast.next != null) {
				fast = fast.next;
				slow= slow.next;
			}
		}
		return slow;
		
	}
	
	public static boolean loopDetect(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;

	}
	
	//DeleteNode
	
	void deleteNode(int key) 
    { 
        // Store head node 
        Node temp = head, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.data == key) 
        { 
            head = temp.next; // Changed head 
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return; 
  
        // Unlink the node from linked list 
        prev.next = temp.next; 
    } 
	
	public void deleteNode(Node node) {

		if (node.next == null) {
			node = null;
		}
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
