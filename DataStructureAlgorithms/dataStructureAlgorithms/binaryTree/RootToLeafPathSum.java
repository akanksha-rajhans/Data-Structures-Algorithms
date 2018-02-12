package binaryTree;

public class RootToLeafPathSum extends BinaryTree{
	
	public void rootToLeafSum(Node root){
		if(root==null)
			return;
		int sum=root.data;
		if(root.left==null && root.right==null){
			System.out.println("Sum for leaf node "+root.data+" is: "+sum);
		}
		else{
			if(root.left!=null){
				rootToLeafSumUtil(root.left, sum);
			}
			if(root.right!=null){
				rootToLeafSumUtil(root.right, sum);
			}
		}
	}
	
	void rootToLeafSumUtil(Node root, int sum){
		sum+=root.data;
		if(root.left==null && root.right==null){
			System.out.println("Sum for leaf node "+root.data+" is: "+sum);
			return;
		}
		if(root.left!=null){
			rootToLeafSumUtil(root.left, sum);
		}
		if(root.right!=null){
			rootToLeafSumUtil(root.right, sum);
		}
	}
	
	public static void main(String[] args) {
		RootToLeafPathSum tree = new RootToLeafPathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(8);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.rootToLeafSum(tree.root);
	}

}
