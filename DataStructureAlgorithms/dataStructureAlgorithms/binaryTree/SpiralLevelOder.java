package binaryTree;

import java.util.Stack;

public class SpiralLevelOder extends BinaryTree{
	
	public void printSpiralOrder(Node root){
		Stack<Node> st1=new Stack<>();
		Stack<Node> st2=new Stack<>();
		st1.push(root);
		while(!st1.isEmpty() || !st2.isEmpty()){
			while(!st1.isEmpty()){
				Node temp=st1.pop();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					st2.push(temp.left);
				if(temp.right!=null)
					st2.push(temp.right);
			}
			while(!st2.isEmpty()){
				Node temp=st2.pop();
				System.out.print(temp.data+" ");
				if(temp.right!=null)
					st2.push(temp.right);
				if(temp.left!=null)
					st2.push(temp.left);
			}
		}
	}

	public static void main(String[] args) {
		SpiralLevelOder tree = new SpiralLevelOder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printSpiralOrder(tree.root);
	}

}
