package acyclicity;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
	
	static int cycle = 0;
	
	public static class Vertex {
		int vertex;
		boolean visited;
		int cc;
		ArrayList<Integer> edges;

		Vertex(int v, ArrayList<Integer> e) {
			vertex = v;
			edges = e;
			cc = 0;
			visited = false;
		}

		boolean isVisited() {
			return visited;
		}

		void visit() {
			visited = true;
		}
	}
	
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
    	Vertex[] vertices = new Vertex[adj.length];

		for (int i = 0; i < adj.length; i++) {
			vertices[i] = new Vertex(i, adj[i]);
		}
		for (int i = 0; i < adj.length; i++) {
			if (!vertices[i].isVisited()) {
				explore(vertices[i], vertices, vertices[i].vertex);
				if(cycle == 1)
					return 1;
			}
		}
        return 0;
    }
    
    private static void explore(Vertex v, Vertex[] vertices, int value) {
		v.visit();		
		for (Integer w : v.edges) {
			if(w == value)
				cycle = 1;
			else if (!vertices[w].isVisited())				
					explore(vertices[w], vertices, value);			
		}		
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

