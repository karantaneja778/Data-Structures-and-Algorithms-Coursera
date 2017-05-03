package tree_height;

import java.util.*;
import java.io.*;

public class tree_height {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class Node {
		private final List<Node> children = new ArrayList<>();
		private final int parent;

		public Node(int parent) {
			this.parent = parent;
		}

		public List<Node> getChildren() {
			return children;
		}

		public int getParent() {
			return parent;
		}
		
		public Boolean isLeaf() {
			return getChildren().isEmpty();
		}
		
		public void addChild(Node child) {			
			children.add(child);
		}
	}

	public class TreeHeight {
		int n;
		int parent[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
			// Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		int computeHeightFaster() {
			
			Node[] nodes = new Node[n];
			for(int i=0; i<n; i++)
				nodes[i] = new Node(i);
			int root = -1;
			for(int child_index=0; child_index<n; child_index++) {
				if(parent[child_index] == -1)
					root = child_index;
				else
					nodes[parent[child_index]].addChild(nodes[child_index]);
			}
				
			int maxHeight = getHeight(nodes[root]);
			
			return maxHeight;
		}
		
		int getHeight(Node n){
		    if(n.isLeaf()){
		         return 0;
		    }else{
		        int maxDepth = 1;
		        for (Node child : n.getChildren()){
		            maxDepth = Math.max(maxDepth, getHeight(child));
		        }

		        return maxDepth + 1;
		    }
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeightFaster());
	}
}
