package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree extends BinaryTree {
	
	int findHeight(Node root){
		if(root==null)
			return 0;
		else{
			int lheight=findHeight(root.left);
			int rheight=findHeight(root.right);
			
			return (lheight>rheight?lheight+1:rheight+1);
		}
	}
	
	public int findHeightIterative(Node root){
		if(root==null)
			return 0;
		int height=0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null){
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			if(temp==null && !q.isEmpty()){
				height++;
				q.add(null);
			}
			if(temp==null && q.isEmpty()){
				height++;
			}
		}
		return height;
	}

	
	public static void main(String[] args) {
		HeightOfTree tree = new HeightOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(5);
        System.out.println("Height of Tree is "+tree.findHeightIterative(tree.root));
	}

}
