package binaryTree;

public class MaxSumBetweenTwoLeaves extends BinaryTree{
	int max=Integer.MIN_VALUE;
	int maxSumForTwoLeafNodes(Node root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return root.data;
		else{
			int left=0;int right=0;
			if(root.left!=null)
				left+=maxSumForTwoLeafNodes(root.left);
			if(root.right!=null)
				right+=maxSumForTwoLeafNodes(root.right);
			max=Math.max(max, left+right+root.data);
			return (left>right?left+root.data:right+root.data);
		}
	}
	
	public static void main(String[] args) {
		MaxSumBetweenTwoLeaves tree = new MaxSumBetweenTwoLeaves();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(0);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(0);
        tree.maxSumForTwoLeafNodes(tree.root);
        System.out.println(tree.max);
	}

}
