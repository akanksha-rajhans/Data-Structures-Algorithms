package binaryTree;

import java.util.Stack;

public class FindInBinaryTree extends BinaryTree{
	
	public boolean findRecur(Node root, int data){
		if(root==null)
			return false;
		if(root.data==data)
			return true;
		else{
			return(findRecur(root.left,data)||findRecur(root.right,data));
		}
	}

	public boolean find(Node root, int data){
		if(root==null)
			return false;
		Stack<Node> st=new Stack<>();
		st.push(root);
		while(!st.isEmpty()){
			Node temp=st.pop();
			if(temp.data==data)
				return true;
			else{
				if(temp.left!=null)
					st.push(temp.left);
				if(temp.right!=null)
					st.push(temp.right);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FindInBinaryTree tree=new FindInBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //With Recursion
        //System.out.println("Element found in tree: "+tree.findRecur(tree.root, 31));
        System.out.println("Element found in tree: "+tree.find(tree.root, 3));
	}

}
