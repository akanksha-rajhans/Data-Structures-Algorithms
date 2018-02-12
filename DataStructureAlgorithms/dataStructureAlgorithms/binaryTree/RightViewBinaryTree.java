package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

//last node in level order traversal
public class RightViewBinaryTree extends BinaryTree{
	
	public void printRightView(Node root){
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp1=q.peek();

			int count=q.size();
			Node temp=null;
			int i;
			for(i=1; i<=count; i++){
				temp=q.poll();
			}
			if(--i==count)
				System.out.print(temp.data+" ");
			if(temp1.left!=null)
				q.add(temp1.left);
			if(temp1.right!=null)
				q.add(temp1.right);
		}
	}

	public static void main(String[] args) {
		RightViewBinaryTree tree = new RightViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printRightView(tree.root);
	}

}
