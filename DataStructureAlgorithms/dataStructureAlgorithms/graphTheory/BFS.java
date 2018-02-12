package graphTheory;

import java.util.*;

public class BFS extends Graph {

	BFS(int v) {
		super(v);
	}
	
	void breadthFirstSearch(int s){
		boolean[] visited=new boolean[getV()];
		LinkedList<Integer> queue=new LinkedList<Integer>();
		
		visited[s]=true;
		queue.add(s);
		
		while(!queue.isEmpty()){
			int i=queue.poll();
			System.out.println(i+" ");
			
			Iterator<Integer> itr=adj[i].listIterator();
			while(itr.hasNext()){
				int n=itr.next();
				if(!visited[n]){
					visited[n]=true;
					queue.add(n);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		BFS g=new BFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.breadthFirstSearch(0);
	}

}
