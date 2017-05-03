package connected_components;

import java.util.ArrayList;
import java.util.Scanner;

import reachability.Reachability.Vertex;

public class ConnectedComponents {
	static int cNum = 1;

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

	private static int numberOfComponents(ArrayList<Integer>[] adj) {

		Vertex[] vertices = new Vertex[adj.length];

		for (int i = 0; i < adj.length; i++) {
			vertices[i] = new Vertex(i, adj[i]);
		}
		for (int i = 0; i < adj.length; i++) {
			if (!vertices[i].isVisited()) {
				explore(vertices[i], vertices);
				++cNum;
			}
		}
		return --cNum;
	}

	private static void explore(Vertex v, Vertex[] vertices) {
		v.visit();
		v.cc = cNum;
		for (Integer w : v.edges) {
			if (!vertices[w].isVisited()) {
				explore(vertices[w], vertices);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			adj[x - 1].add(y - 1);
			adj[y - 1].add(x - 1);
		}
		System.out.println(numberOfComponents(adj));
	}
}
