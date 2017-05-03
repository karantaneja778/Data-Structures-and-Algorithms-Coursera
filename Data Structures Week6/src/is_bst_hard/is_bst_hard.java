package is_bst_hard;

import java.util.*;

import java.io.*;

public class is_bst_hard {
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

	public class IsBST {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
		}

		public class TreeNode {
			int data;
			TreeNode left;
			TreeNode right;

			TreeNode(int data) {
				this.data = data;
			}
		}

		int nodes;
		Node[] tree;
		TreeNode root;
		TreeNode[] treeNodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new Node[nodes];
			treeNodes = new TreeNode[nodes];
			for (int i = 0; i < nodes; i++) {
				tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
			}
			for (int i = 0; i < nodes; i++) {
				treeNodes[i] = new TreeNode(tree[i].key);
			}
			for (int i = 0; i < nodes; i++) {
				if (tree[i].left != -1)
					treeNodes[i].left = treeNodes[tree[i].left];
				if (tree[i].right != -1)
					treeNodes[i].right = treeNodes[tree[i].right];
			}
		}

		boolean isBinarySearchTree() {
			// Implement correct algorithm here
			if (nodes == 0)
				return true;
			root = treeNodes[0];
			return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		private boolean isValidBST(TreeNode node, int MIN, int MAX) {
			if (node == null)
				return true;

			if (node.data < MIN || node.data > MAX)
				return false;
			boolean leftIsBst = false;

			if (node.left != null) {

				if (node.left.data < node.data) {
					leftIsBst = isValidBST(node.left, MIN, node.data);
				} else {
					leftIsBst = false;
				}
			} else {
				leftIsBst = true;
			}
			boolean rightIsBst = false;

			if (node.right != null) {

				if (node.right.data >= node.data) {

					rightIsBst = isValidBST(node.right, node.data, MAX);
				} else {

					rightIsBst = false;
				}
			} else {
				rightIsBst = true;
			}

			return (leftIsBst && rightIsBst);

		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst_hard().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
