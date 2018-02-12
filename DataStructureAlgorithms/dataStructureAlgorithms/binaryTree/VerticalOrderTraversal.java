package binaryTree;

public class VerticalOrderTraversal extends BinaryTree{
	
	public void printVerticalOrder(Node root){
		
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printVerticalOrder(tree.root);
	}

}
