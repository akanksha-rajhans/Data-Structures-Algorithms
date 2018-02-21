package binaryTree;

class Node{
	int data;
	Node left; Node right;
	Node(int data){
		this.data=data;
		this.right=this.left=null;
	}
}

public class BinaryTree {
	public Node root;
}
