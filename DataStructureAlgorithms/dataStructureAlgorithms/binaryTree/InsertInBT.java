package binaryTree;

import java.util.*;

public class InsertInBT extends BinaryTree{
	
	public boolean insertInBTIterative(Node root,int data){
		if(root==null)
			return false;
		Queue<Node> st=new LinkedList<>();
		st.add(root);
		while(!st.isEmpty()){
			Node temp=st.remove();
			if(temp.left==null){
				temp.left=new Node(data);
				return true;
			}
			else
				st.add(temp.left);
			if(temp.right==null){
				temp.right=new Node(data);
				return true;
			}
			else
				st.add(temp.right);
		}
		return false;
	}

	public static void main(String[] args) {
		InsertInBT tree=new InsertInBT();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Node inserted n Binary Tree: "+tree.insertInBTIterative(tree.root,19));
        LevelOrderTraversal obj=new LevelOrderTraversal();
        obj.printLevelOrder(tree.root);
	}

}
