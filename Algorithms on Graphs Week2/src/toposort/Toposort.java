package toposort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import acyclicity.Acyclicity.Vertex;

public class Toposort {
	static int clock = 0;
	
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
	
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        clock = adj.length-1;
        ArrayList<Integer> order = new ArrayList<Integer>(adj.length);
        
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		for (int i = 0; i < adj.length; i++) {
			vertices.add(new Vertex(i, adj[i]));
			order.add(0);
		}
		for (Vertex vertex : vertices) {
			if(!vertex.isVisited())
				explore(vertex, vertices, order);
		}
		
		
        return order;
    }
    
    private static void explore(Vertex v, ArrayList<Vertex> vertices, ArrayList<Integer> order) {
		v.visit();		
		for (Integer w : v.edges) {
			if (!vertices.get(w).isVisited())				
				explore(vertices.get(w), vertices, order);			
		}
		order.set(clock, v.vertex);
		clock--;
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
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

