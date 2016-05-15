/**
* Favor static member classes over nonstatic 
*
* This example shows the [incomplete] implementation of Linked List using 'Node' 
* inner class i.e. The consumer of LinkedList class does not need to know about
* 'Node' class at all.
*
* Note that the Linked list implementation is "Doubly-Linked-List".
*/
class LinkedList {
	Node head;

	// The following class is an inner class as 'LinkedList' is the sole 
	// consumer of this class.
	//
	// Following class is marked 'static' as Node instance does not need access  
	// to enclosing instance for it's operations. 
	private static class Node{
		// Following fields cannot be marked final as we need to support insert, 
		// delete operation on Linked List.
		private Node next; // reference to next node
		private Node prev; // reference to previous node

		// Following field is marked final as this implementation of Linked List
		// does not support editing of data attribute of any node.
		private final String data; // actual data of the node

		public Node(String data) {
			this.data = data;
		}

		// mutators
		void setNext(Node node) {
			this.next = node;
		}

		void setPrev(Node node) {
			this.prev = node;
		}

		// accessors
		Node getNext() {
			return this.next;
		}

		Node getPrev() {
			return this.prev;
		}

		String getData() {
			return this.data;
		}

		// utility methods
		boolean hasNext() {
			if (this.next != null) return true;
			return false;
		}

		boolean hasPrev() {
			if (this.prev != null) return true;
			return false;
		}
	}

	// Linked List related operations

	/**
	* Inserts new node element
	*/
	void insert(String val) {
		Node node = new Node(val);
		// Check if this List's head is null or has elements
		if (head==null) {
			head = node;
		} else {
			// has head element
			node.next = head;
			head = node;
		}
	}

	@Override public String toString() {
		if (head==null) {
			return "Linked List is empty";
		}
		return "Head node: " + head.data;
	}
}

class item22 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.toString());
		list.insert("Rajat");
		list.insert("Saxena");
		// print again
		System.out.println(list.toString());
	}
}