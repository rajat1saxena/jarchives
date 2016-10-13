/**
* A tree node, containing references to a parent, left child and right 
* child. 
*/
class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	Node<T> p; // parent
	Node<T> left; // left child
	Node<T> right; // right child
	T key; 

	public Node(T t) {
		this.key = t;
	}

	@Override
	public int compareTo (Node<T> item) {
		return key.compareTo(item.key);
	}

	@Override
	public String toString () {
		return this.key.toString();
	}
}

/**
* Provider of common tree functionalities like inorder tree walk, insertion
* deletion etc.
*/
class TreeAlgorithms<T extends Comparable<T>> {
	Node<T> root;

	/**
	* Insert operation on a tree rooted at 'root'.
	*/
	void insert (Node<T> z) {
		Node<T> x = root;
		Node<T> y = null;
		while (x != null) {
			y = x;
			if (z.compareTo(x) < 0) {
				x = x.left;
			}
			else { 
				x = x.right;
			}
		}	
		z.p = y;
		if (y == null) {
			root = z;
		}
		else if (z.compareTo(y) < 0) {
			y.left = z;
		}
		else {
			y.right = z;
		}
	}

	/**
	* In-order traversal to the tree rooted at 'n'.
	*/
	void inorder (Node<T> n) {
		if (n != null) {
			inorder(n.left);
			System.out.println(n.key);
			inorder(n.right);
		}
	}

	/**
	* Returns tree minimum of the tree, rooted at n.
	*/
	<T extends Comparable<T>> Node<T> minimum(Node<T> n) {
		Node<T> x = n;
		while (x.left!=null) {
			x = x.left;	
		}
		return x;
	}

	/**
	* Returns tree maximum of the tree, rooted at n.
	*/
	<T extends Comparable<T>> Node<T> maximum(Node<T> n) {
		Node<T> x = n;
		while (x.right!=null) {
			x = x.right;	
		}
		return x;
	}

	/**
	* Transplants the node v at node u's place.
	*/
	private void transplant (Node<T> u, Node<T> v) {
		if (u.p == null) {
			root = v;
		}
		else if (u.compareTo(u.p) < 0)
			u.p.left = v;
		else 
			u.p.right = v; 
		if (v != null)
			v.p = u.p;
	}

	/**
	* Deletes the node z of the tree.
	*/
	void delete (Node<T> z) {
	    Node<T> y = null;
		if (z.left == null)
			transplant (z, z.right);
		else if (z.right == null)
			transplant (z, z.left);
		else 
			y = minimum (z.right);
			if (y.p != z) {
				transplant (y, y.right);
				y.right = z.right;
				y.right.p = y;	
			}
			transplant (z, y);
			y.left = z.left;
			y.left.p = y;
	} 

	/**
	* Returns predecessor of a node.
	*/
	<T extends Comparable<T>> Node<T> predecessor(Node<T> n) {
		Node<T> y = null;
		if (n.left != null) {
			y = maximum (n.left);
		} else {
				y = n.p;
				while (y != null && y.right != n) {
					n = y;
					y = y.p;	
				}
		}
		return y;
	}	
}

public class tree {
	public static void main(String args[]) {
		Node<Integer> n1 = new Node<Integer>(3);
		Node<Integer> n2 = new Node<Integer>(4);
		Node<Integer> n3 = new Node<Integer>(2);
		Node<Integer> n4 = new Node<Integer>(1);
		
		TreeAlgorithms<Integer> tA = new TreeAlgorithms<Integer>();		
		tA.insert(n1);
		tA.insert(n2);
		tA.insert(n3);
		tA.insert(n4);

		System.out.println("Inorder");
		tA.inorder(tA.root);
		System.out.println("Min/Max");
		System.out.println(tA.minimum(n3).key);
		System.out.println(tA.maximum(n3).key);

		System.out.println("Predecessor/Successor");
		System.out.println(tA.predecessor(n4));
		System.out.println(tA.predecessor(n2));

		System.out.println("Deletion");
		tA.delete(n1);
		tA.inorder(tA.root);

	}
}
