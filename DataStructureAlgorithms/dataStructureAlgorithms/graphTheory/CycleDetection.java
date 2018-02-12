package graphTheory;

import java.util.Iterator;

public class CycleDetection extends Graph{
	
	CycleDetection(int v) {
		super(v);
	}
	
	boolean isCyclicUtil(int c, boolean[] visited, int p){
		visited[c]=true;
		Iterator<Integer> itr=adj[c].iterator();
		while(itr.hasNext()){
			int a=itr.next();
			if(!visited[a]){
				if(isCyclicUtil(a, visited, c))
					return true;
			}
			else if(a!=p)
				return true;
		}
		return false;
	}
	
	boolean isCyclic(){
		boolean[] visited=new boolean[getV()];
		for(int a=0; a<getV(); a++)
			visited[a]=false;
		
		for(int i=0; i<getV(); i++){
			if(visited[i]==false){
				if(isCyclicUtil(i,visited,-1))
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		CycleDetection cyc=new CycleDetection(3);
		cyc.addEdge(0, 1);
		cyc.addEdge(1, 2);
		//cyc.addEdge(2, 0);
		/*cyc.addEdge(2, 0);
		cyc.addEdge(0, 3);
		cyc.addEdge(3, 4);*/
		
		if(cyc.isCyclic())
			System.out.println("Graph Contains Cycle");
		else
			System.out.println("Does not Contains Cycle");
		
	}

}
