package binaryTree;

//import java.util.*;

public class DiameterOfBT extends BinaryTree{
	
	public int height(Node root){
		if(root==null)
			return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		return (lheight>rheight?lheight+1:rheight+1);
	}
	
	public int getDiameter(Node root){
		if(root==null)
			return 0;
		
		int lheight=height(root.left);
		int rheight=height(root.right);
		
		int ldia=getDiameter(root.left);
		int rdia=getDiameter(root.right);
		
		return (Math.max(lheight+rheight+1, Math.max(ldia, rdia)));
				
		
		/*method2
		 * if(root==null)
			return 0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int dia=0;
		while(!q.isEmpty()){
			int count=q.size();
			dia=Math.max(dia, count);
			
			while(count-->0){
				Node temp=q.remove();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return dia;*/
	}
	
	public static void main(String[] args) {
		DiameterOfBT tree= new DiameterOfBT();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.left.right=new Node(7);
        System.out.println("Diameter of the tree is: "+tree.getDiameter(tree.root));
	}

}
