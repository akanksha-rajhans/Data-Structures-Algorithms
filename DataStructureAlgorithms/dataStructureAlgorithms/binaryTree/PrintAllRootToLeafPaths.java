package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllRootToLeafPaths extends BinaryTree{
	
	void printPaths(Node root){
		Queue<Node> q=new LinkedList<>();
		printPathsUtil(root, q);
	}
	
	void printPathsUtil(Node root, Queue<Node> q){
		q.add(root);
		if(root.left!=null)
			printPathsUtil(root.left, q);
		if(root.right!=null)
			printPathsUtil(root.right, q);
		if(root.left==null && root.right==null)
			prinPathRootToLeaf(q);
		int count=q.size()-1;
		while(count-->0){
			Node temp=q.poll();
			q.add(temp);
		}
		q.poll();
	}
	
	void prinPathRootToLeaf(Queue<Node> q){
		int size=q.size();
		for(int i=0; i<size;i++){
			Node temp=q.poll();
			System.out.print(temp.data+" ");
				q.add(temp);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PrintAllRootToLeafPaths tree=new PrintAllRootToLeafPaths();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(10);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printPaths(tree.root);
	}

}
