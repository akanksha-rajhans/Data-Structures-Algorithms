package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

//do vertical order traversal.If multiple nodes in same vertical, print which comes first in level order
public class TopViewBinaryTree extends BinaryTree{
	
	public void printTopView(Node root){
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		Queue<Integer> distance=new LinkedList<>();
		q.add(root);
		distance.add(0);
		//HashSet<Integer> set=new HashSet<Integer>();
		TreeMap<Integer, Node> map=new TreeMap<>();
		while(!q.isEmpty()){
			Node temp=q.poll();
			int d=distance.poll();
			
			if(map.get(d)==null){
				map.put(d, temp);
			}
			
			/*if(!set.contains(d)){
				set.add(d);
				System.out.print(temp.data+" ");
			}*/
			
			if(temp.left!=null){
				q.add(temp.left);
				distance.add(d-1);
			}
			if(temp.right!=null){
				q.add(temp.right);
				distance.add(d+1);
			}
		}
		printTopViewOfTree(map);
	}
	
	void printTopViewOfTree(TreeMap<Integer, Node> map){
		for(int i:map.keySet()){
			System.out.print(map.get(i).data+" ");
		}
	}
	
	public static void main(String[] args) {
		TopViewBinaryTree tree = new TopViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
     
        tree.printTopView(tree.root);
	}

}
