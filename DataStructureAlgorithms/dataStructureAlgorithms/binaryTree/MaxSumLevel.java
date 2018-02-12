package binaryTree;

import java.util.*;

public class MaxSumLevel extends BinaryTree{
	
	public int maxSum(Node root){
		if(root==null)
			return 0;
		int max=Integer.MIN_VALUE; int sum=0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null){
				sum+=temp.data;			
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			if(temp==null && !q.isEmpty()){
				q.add(null);
				max=(max<sum)?sum:max;
				sum=0;
			}
			if(temp==null && q.isEmpty()){
				max=(max<sum)?sum:max;
			}
		}
		return max;
	/*	if(root==null)
			return 0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int maxSum=root.data;
		while(!q.isEmpty()){
			int count=q.size();
			int sum=0;
			
			while(count-->0){
				Node temp=q.remove();
				sum+=temp.data;
				maxSum=Math.max(maxSum, sum);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return maxSum;*/
	}

	public static void main(String[] args) {
		MaxSumLevel tree=new MaxSumLevel();
		tree.root = new Node(11);
        tree.root.left = new Node(7);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Maximum Sum of Level is: "+tree.maxSum(tree.root));
	}

}
