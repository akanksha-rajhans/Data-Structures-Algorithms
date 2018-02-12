package graphTheory;

import java.util.Iterator;
import java.util.Stack;
			
public class StronglyConnectedComponents extends Graph {

	StronglyConnectedComponents(int v) {
		super(v);
	}		
	
	void DfsUtil(int n, boolean[] visited, Graph g){
		visited[n]=true;
		System.out.print(n+" ");
		
		Iterator<Integer> itr=g.adj[n].iterator();
		while(itr.hasNext()){
			int i=itr.next();
			if(!visited[i])
				DfsUtil(i, visited, g);
		}
	}
	
	Graph getTranspose(){
		Graph g=new Graph(getV());
		for(int i=0; i<getV(); i++){
			Iterator<Integer> itr=adj[i].listIterator();
			while(itr.hasNext()){
				g.adj[itr.next()].add(i);
			}
		}
		return g;
	}
	
	void fillOrder(int i, boolean[] visited, Stack st){
		visited[i]=true;
		Iterator<Integer> itr=adj[i].listIterator();
		while(itr.hasNext()){
			int n=itr.next();
			if(visited[n]==false){
				fillOrder(n, visited, st);
			}
		}
		st.push(new Integer(i));
	}
	
	void printSCC(){																				
		Stack<Integer> st=new Stack<Integer>();
		int i;
		boolean[] visited=new boolean[getV()];
		for(i=0; i<getV(); i++)
			visited[i]=false;
		
		for(i=0; i<getV(); i++){
			if(visited[i]==false){
				fillOrder(i, visited, st);
			}
		}
		
		Graph g=getTranspose();
		
		for(i=0; i<getV(); i++)
			visited[i]=false;
		
		while(!st.empty()){
			int b=st.pop();
			if(visited[b]==false){
				DfsUtil(b,visited,g);
				System.out.println();
			}
		}
		
	}

	public static void main(String[] args) {
		StronglyConnectedComponents scc=new StronglyConnectedComponents(5);
		scc.addEdge(1, 0);
		scc.addEdge(0, 2);
		scc.addEdge(2, 1);
		scc.addEdge(0, 3);
		scc.addEdge(3, 4);
		System.out.println("Following are strongly connected components in given graph ");
		
		scc.printSCC();
	}

}
