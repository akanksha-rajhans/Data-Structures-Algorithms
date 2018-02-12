package binaryTree;

import java.util.Stack;

public class InorderWithStack extends BinaryTree {
	
	void inorder(Node root){
		if(root==null)
			return;
		Stack<Node> st=new Stack<>();
		while(root!=null){
			st.push(root);
			root=root.left;
		}
		while(st.size()>0){
			root=st.pop();
			System.out.print(root.data+" ");
			if(root.right!=null){
				root=root.right;
				while(root!=null){
					st.push(root);
					root=root.left;
				}
			}
				
		}
	}

	public static void main(String[] args) {
		InorderWithStack tree = new InorderWithStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder(tree.root);
	}

}
