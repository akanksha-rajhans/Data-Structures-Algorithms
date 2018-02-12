package graphTheory;

import java.util.Iterator;

public class DFS extends Graph {
	DFS(int v) {
		super(v);
	}
	
	void dfsUtil(int s, boolean[] visited){
		visited[s]=true;
		System.out.println(s+" ");
		
		Iterator<Integer> itr=adj[s].listIterator();
		while(itr.hasNext()){
			int n=itr.next();
			if(!visited[n]){
				dfsUtil(n,visited);
			}
		}
	}
	
	void depthFirstSearch(int s){
		boolean[] visited=new boolean[getV()];
		for(int i=0; i<getV(); i++){
			if(visited[i]==false)
				dfsUtil(i, visited);
		}
		
	}
	
	public static void main(String[] args) {
		DFS dfs=new DFS(5);
		dfs.addEdge(0, 2);
		dfs.addEdge(0, 1);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);
		dfs.addEdge(4, 4);
		
		dfs.depthFirstSearch(2);
	}

}
