package binaryTree;

public class TwoTreesMirror extends BinaryTree{
	
	public boolean areMirrors(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		else{
			if(root1.data==root2.data){
				boolean val1=areMirrors(root1.left, root2.right);
				boolean val2=areMirrors(root1.right, root2.left);
				return val1 && val2;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TwoTreesMirror tree1 = new TwoTreesMirror();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        
        TwoTreesMirror tree2 = new TwoTreesMirror();
        tree2.root = new Node(1);
        tree2.root.left = new Node(3);
        tree2.root.right = new Node(2);
        tree2.root.right.left = new Node(5);
        tree2.root.right.right = new Node(4);
        
        System.out.println(tree1.areMirrors(tree1.root, tree2.root));
	}

}
