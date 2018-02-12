package binaryTree;

import java.util.Queue;
import java.util.LinkedList;;

public class LevelOrderTraversal extends BinaryTree {
	
	void printLevelOrder(Node root){
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null){
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			if(temp==null && !q.isEmpty()){
				q.add(null);
				System.out.println();
				
			}
			
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree.printLevelOrder(tree.root);
	}

}
