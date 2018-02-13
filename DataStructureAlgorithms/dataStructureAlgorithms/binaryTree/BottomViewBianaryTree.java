package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

//do vertical order traversal, print last key of the map
public class BottomViewBianaryTree extends BinaryTree{
	
	void bottomViewOfTree(Node root){
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		Queue<Integer> distance=new LinkedList<>();
		q.add(root);
		distance.add(0);
		TreeMap<Integer, Node> map=new TreeMap<>();
		while(!q.isEmpty()){
			Node temp=q.poll();
			int d=distance.poll();
			map.put(d, temp);
			if(temp.left!=null){
				q.add(temp.left);
				distance.add(d-1);
			}
			if(temp.right!=null){
				q.add(temp.right);
				distance.add(d+1);
			}
		}
		printBottomViewOfTree(map);
	}
	
	void printBottomViewOfTree(TreeMap<Integer, Node> map){
		for(int i:map.keySet()){
			System.out.print(map.get(i).data+" ");
		}
	}

	public static void main(String[] args) {
		BottomViewBianaryTree tree = new BottomViewBianaryTree();
		tree.root=new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(25);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		
		tree.bottomViewOfTree(tree.root);
	}

}
