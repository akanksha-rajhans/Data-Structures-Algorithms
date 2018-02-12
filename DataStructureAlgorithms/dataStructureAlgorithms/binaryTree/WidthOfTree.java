package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//maximum number of elements on a level of binary tree 
public class WidthOfTree extends BinaryTree{
	
	public int findWidth(Node root){
		if(root==null)
			return 0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		int count=1; int size=Integer.MIN_VALUE;
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null){
				/*count=q.size();
				if(size<count)
					size=count;
				System.out.println(size);*/
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			else if(temp==null && !q.isEmpty()){
				count=q.size();
				if(size<count)
					size=count;
				q.add(null);
			}
		}
		return size;
	}

	public static void main(String[] args) {
		WidthOfTree tree = new WidthOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Width of tree is: "+tree.findWidth(tree.root));
        tree.findWidth(tree.root);
	}

}
