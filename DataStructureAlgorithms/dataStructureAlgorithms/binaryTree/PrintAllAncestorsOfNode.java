package binaryTree;

import java.util.Stack;

public class PrintAllAncestorsOfNode extends BinaryTree{
	Stack<Node> s=new Stack<>();
	boolean printAncestors(Node root, int val){
		if(root==null)
			return false;
		if(root.data==val)
			return true;
		if(printAncestors(root.left, val) || printAncestors(root.right, val)){
			s.push(root);
			return true;
		}
		return false;
	}
		
	public static void main(String[] args) {
		PrintAllAncestorsOfNode tree = new PrintAllAncestorsOfNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(8);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printAncestors(tree.root,8);
        while(!tree.s.isEmpty()){
        	System.out.println(tree.s.pop().data+" ");
        }
	}

}
