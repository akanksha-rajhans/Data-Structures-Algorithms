package graphTheory;
import java.util.*;

public class TopologicalSort extends Graph {

	TopologicalSort(int v) {
		super(v);
	}
	
	void topoSortUtil(int i, boolean[] visited, Stack st){
		visited[i]=true;
		int m=0;
		
		Iterator<Integer> itr=adj[i].listIterator();
		while(itr.hasNext()){
			m=itr.next();
			if(!visited[m])
				topoSortUtil(m, visited, st);
		}
		st.push(i);
	}
	
	void topologicalSortFunc(){
		boolean[] visited=new boolean[6];
		Stack st=new Stack<Integer>();
		
		for(int i=0; i<6; i++){
			if(!visited[i])
				topoSortUtil(i,visited, st);
		}
		while(!st.isEmpty()){
			System.out.print(st.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		TopologicalSort tp=new TopologicalSort(6);
		tp.addEdge(5, 2);
		tp.addEdge(5, 0);
		tp.addEdge(4, 0);
		tp.addEdge(4, 1);
		tp.addEdge(2, 3);
		tp.addEdge(3, 1);
		System.out.println("Following is a Topological sort of the given graph");
		tp.topologicalSortFunc();
	}

}
