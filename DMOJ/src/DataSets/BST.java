package DataSets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class BST {

	static Node root;

	class Node {
		Node right;
		Node left;
		int data;

		public Node(int in) {
			data = in;
		}
	}

	public BST() {
		this.root = null;
	}

	// Checks if a node has children
	public boolean hasChildren(Node n) {
		return n.right != null || n.left != null;
	}

	// adds a node to root or creates root if no node
	public void add(int data) {
		Node n = new Node(data);
		if (root == null) {
			root = n;
		} else {
			Node current = root;
			while (true) {
				// Check right
				if (data > current.data) {
					if (current.right == null) {
						current.right = n;
						break;
					} else {
						current = current.right;
					}
				}
				// Check left
				else {
					if (current.left == null) {
						current.left = n;
						break;
					} else {
						current = current.left;
					}
				}
			}
		}
	}
	// Returns the integer data of the node with the highest data that is less
	// than or equal to the given max for a positive bst. If none exist, returns -1.
	public int searchGreatest(int max, Node start) {
		Node current = start;
		int highestPossible = -1;
		while(true){
			if(current.data == max){
				return max;
			}
			if(max > current.data){
				highestPossible = current.data;
			}
			if(max > current.data && current.right != null){
				highestPossible = current.data;
				current = current.right;
			}
			else if(max < current.data && current.left != null){
				current = current.left;
			}
			else{
				return highestPossible;
			}
		}
	}

	// Searches for given data returns true if present, false if not
	public boolean search(int data) {
		Node current = root;
		while (true) {
			if (current.data == data) {
				return true;
			}
			if (data > current.data) {
				if (current.right != null) {
					current = current.right;
				} else {
					return false;
				}
			} else {
				if (current.left != null) {
					current = current.left;
				} else {
					return false;
				}
			}
		}
	}

	// Finds given integer and deletes it from the bst
	public void delete(int data) {
		Node current = root;
		Node parent = root;
		// Search section
		boolean rightOfParent = false;
		while (current.data != data) {
			if (data > current.data) {
				parent = current;
				current = current.right;
				rightOfParent = true;
			} else {
				parent = current;
				current = current.left;
				rightOfParent = false;
			}

		}

		// Delete section
		// Leaf case
		if (!hasChildren(current)) {
			if (rightOfParent) {
				parent.right = null;
			} else {
				parent.left = null;
			}
		}
		// One child case
		else if (current.left == null) {
			if(current == root){
				root = current.right;
			}
			if (rightOfParent) {
				parent.right = current.right;
			} else {
				parent.left = current.right;
			}
		} else if (current.right == null) {
			if(current == root){
				root = current.left;
			}
			if (rightOfParent) {
				parent.right = current.left;
			} else {
				parent.left = current.left;
			}
		}
		// Two child case
		else {
			Node replacement = current.right;
			Node replacementParent = current;
			while (replacement.left != null) {
				replacementParent = replacement;
				replacement = replacement.left;
			}
			if(replacementParent != root){
			replacementParent.left = replacement.right;
			replacement.right = current.right;
			}
			if(current == root){
				root = replacement;
			}
			else if(rightOfParent){
				parent.right = replacement;
			}
			else{
				parent.left = replacement;
			}
			replacement.left = current.left;
		}

	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.println(root.data);
			display(root.right);
		}
	}
	
	//Todo: Fix balancing:
	public void addBalancedArray(int[] sortedArray, BST binaryST) {
		if (sortedArray.length == 1) {
			binaryST.add(sortedArray[0]);
		} else {
			addBalancedArray2(
					Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2),
					binaryST);
			addBalancedArray2(Arrays.copyOfRange(sortedArray,
					sortedArray.length / 2, sortedArray.length), binaryST);
		}
	}
	
	public void addBalancedArray2(int[]sortedArray, BST binaryST){
		if (sortedArray.length == 1) {
			binaryST.add(sortedArray[0]);
		} else {
			addBalancedArray(Arrays.copyOfRange(sortedArray,
					sortedArray.length / 2, sortedArray.length), binaryST);
			addBalancedArray(
					Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2),
					binaryST);
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		BST bst = new BST();

		int gates = Integer.parseInt(b.readLine());
		int planes = Integer.parseInt(b.readLine());
		int[] gateNumbers = new int[gates];
		for (int i = 0; i < gates; i++) {
			gateNumbers[i] = i + 1;
		}
		bst.addBalancedArray(gateNumbers, bst);
		boolean flag = false;
		for (int i = 0; i < planes; i++){
			int request = Integer.parseInt(b.readLine());
			int found = bst.searchGreatest(request, root);
			if(found == -1){
				p.print(i);
				flag = true;
				break;
			}
			else{
				bst.delete(found);
			}
		}
		if(!flag){
			p.print(gates);
		}
		p.close();
	}

}
