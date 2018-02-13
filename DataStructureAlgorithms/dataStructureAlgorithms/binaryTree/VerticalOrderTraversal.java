package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal extends BinaryTree{
	
	public void printVerticalOrder(Node root){
		if(root==null)
			return;
		Queue<Integer> distanceQueue=new LinkedList<Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		TreeMap<Integer, LinkedList<Node>> map=new TreeMap<>();
		queue.add(root);
		distanceQueue.add(0);
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			int distance=distanceQueue.poll();
			if(map.get(distance)==null)
				map.put(distance, new LinkedList<Node>());
			map.get(distance).add(temp);
			if(temp.left!=null){
				queue.add(temp.left);
				distanceQueue.add(distance-1);
			}
			if(temp.right!=null){
				queue.add(temp.right);
				distanceQueue.add(distance+1);
			}
		}
		printVerticalTraversal(map);
	}
	
	void printVerticalTraversal(TreeMap<Integer, LinkedList<Node>>map){
		for(int i:map.keySet()){
			for(Node n:map.get(i)){
				System.out.print(n.data+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printVerticalOrder(tree.root);
	}

}
