package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//print first node at every level
public class LeftViewBinaryTree extends BinaryTree{
	
	public void printLeftView(Node root){
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		q.add(null);
		boolean isFirst=true;
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null && isFirst){
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				isFirst=false;
			}
			else if(temp==null && q.size()>1){
				isFirst=true;
				q.add(null);
			}
			else if(temp!=null){
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		
	}
	
	public static void main(String[] args) {
		LeftViewBinaryTree tree = new LeftViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printLeftView(tree.root);
	}

}
