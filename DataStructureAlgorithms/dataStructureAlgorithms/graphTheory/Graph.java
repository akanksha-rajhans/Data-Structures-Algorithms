package graphTheory;

import java.util.LinkedList;

public class Graph {
	private int V;
	public LinkedList<Integer> adj[];
	
	Graph(int v){
		this.V=v;
		this.adj=new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i]=new LinkedList();
	}
	
	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	void addEdge(int v, int u){
		adj[v].add(u);
	}
	
}
