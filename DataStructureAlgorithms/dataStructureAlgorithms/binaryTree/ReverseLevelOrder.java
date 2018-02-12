package binaryTree;

import java.util.*;

public class ReverseLevelOrder extends BinaryTree{
	
	public void printReverse(Node root){
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		Stack<Node> st=new Stack<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null){
				st.push(temp);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			if(temp==null && !q.isEmpty()){
				q.add(null);
				while(!st.isEmpty()){
					System.out.print(st.pop().data+" ");
				}
				System.out.println();
			}
			else if(temp==null && q.isEmpty())
			{
				while(!st.isEmpty()){
					System.out.print(st.pop().data+" ");
				}
				System.out.println();
			}
		}
	
		/*Stack<Node> st=new Stack<>();
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp=q.remove();
			st.push(temp);
			if(temp.right!=null)
				q.add(temp.right);
			
			if(temp.left!=null)
				q.add(temp.left);
			
		}
		while(!st.isEmpty())
			System.out.print(st.pop().data+" ");
			*/
	}
	void printLevel(Stack<Node> st){
		while(!st.isEmpty()){
			System.out.print(st.pop().data+" ");
		}
}

	public static void main(String[] args) {
		ReverseLevelOrder tree=new ReverseLevelOrder();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printReverse(tree.root);
	}

}
