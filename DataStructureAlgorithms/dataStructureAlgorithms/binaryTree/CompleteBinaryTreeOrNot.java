package binaryTree;

public class CompleteBinaryTreeOrNot extends BinaryTree {
	int index=0;
	
	public int countNodes(Node root){
		if(root==null)
			return 0;
		return (1+countNodes(root.left)+countNodes(root.right));
	}
	
	public boolean isComplete(Node root){
		int nodeCount=countNodes(root);
		return isCompleteUtil(root, 0, nodeCount);
	}
	
	boolean isCompleteUtil(Node root, int index, int nodeCount){
		if(root==null)
			return true;
		if(index>=nodeCount)
			return false;
		return(isCompleteUtil(root.left, 2*index+1, nodeCount) && 
			   isCompleteUtil(root.right, 2*index+2, nodeCount));
	}
	
	public static void main(String[] args) {
		CompleteBinaryTreeOrNot tree = new CompleteBinaryTreeOrNot();
	       
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
 
        if(tree.isComplete(tree.root) == true)
            System.out.println("Given binary tree is complete");
        else
            System.out.println("Given binary tree is not complete");
	}

}
