package binaryHeap;

/*isHeap to check heap if root is greater than its children and 
 * isComplete to check if almost complete BT
 */
class Node{
	int data;
	Node left; Node right;
	Node(int data){
		this.data=data;
		this.right=this.left=null;
	}
}

class BinaryTree {
	public Node root;
}

public class CheckBinaryTreeIsHeap extends BinaryTree{
	
	int countNodes(Node root){
		if(root==null)
			return 0;
		return (1+countNodes(root.left)+countNodes(root.right));
	}
	
	boolean isCompleteUtil(Node root, int index, int nodeCount){
		if(root==null)
			return true;
		if(index>=nodeCount)
			return false;
		return (isCompleteUtil(root.left, 2*index+1, nodeCount) && 
				isCompleteUtil(root.right, 2*index+2, nodeCount));
	}
	
	boolean isComplete(Node root){
		int nodeCount=countNodes(root);
		return isCompleteUtil(root, 0, nodeCount);
	}
	
	boolean isHeapUtil(Node root){
		if(root==null)
			return true;
		if(root.right==null)
			return (root.data>=root.left.data);
		else{
			if(root.data>=root.left.data && root.data>=root.right.data)
				return true;
			else
				return false;
		}
	}
	
	boolean isHeap(Node root){
		if(root==null)
			return false;
		if(isComplete(root)==true && isHeapUtil(root)==true)
			return true;
		return false;
	}

	public static void main(String[] args) {
		CheckBinaryTreeIsHeap tree = new CheckBinaryTreeIsHeap();
       
		tree.root = new Node(10);
		tree.root.left = new Node(9);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.left.left.left = new Node(3);
		tree.root.left.left.right = new Node(2);
		tree.root.left.right.left = new Node(1);
 
        if(tree.isHeap(tree.root) == true)
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    }
}


