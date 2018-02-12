package binaryTree;

public class AreEqual extends BinaryTree{
	
	public boolean areMirrors(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		else{
			if(root1.data!=root2.data)
				return false;
			}
	
		boolean val1=areMirrors(root1.left, root2.left);
		boolean val2=areMirrors(root1.right, root2.right);
		return val1 && val2;
	}

	public static void main(String[] args) {
		AreEqual tree1 = new AreEqual();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        
        AreEqual tree2 = new AreEqual();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        
        System.out.println(tree1.areMirrors(tree1.root, tree2.root));
	}

}
