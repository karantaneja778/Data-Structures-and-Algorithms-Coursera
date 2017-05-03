package tree_orders;

import java.util.*;

import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		TreeNode root;
		TreeNode[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			nodes = new TreeNode[n];
			key = new int[n];
			left = new int[n];
			right = new int[n];

			for (int i = 0; i < n; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
				nodes[i] = new TreeNode(key[i]);
			}
			for (int i = 0; i < n; i++) {
				if (left[i] != -1)
					nodes[i].left = nodes[left[i]];
				if (right[i] != -1)
					nodes[i].right = nodes[right[i]];
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

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			root = nodes[0];
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode currentNode = root;

			while (!s.empty() || currentNode != null) {
				if (currentNode != null) {
					s.push(currentNode);
					currentNode = currentNode.left;
				} else {
					TreeNode n = s.pop();
					result.add(n.data);
					currentNode = n.right;
				}
			}
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			root = nodes[0];
			stack.push(root);

			while (!stack.empty()) {

				TreeNode n = stack.pop();
				result.add(n.data);

				if (n.right != null) {
					stack.push(n.right);
				}
				if (n.left != null) {
					stack.push(n.left);
				}
			}
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode current = root;

			while (true) {
				if (current != null) {
					if (current.right != null)
						s.push(current.right);
					s.push(current);
					current = current.left;
					continue;
				}

				if (s.isEmpty())
					break;
				current = s.pop();

				if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
					s.pop();
					s.push(current);
					current = current.right;
				} else {
					result.add(current.data);
					current = null;
				}
			}

			return result;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_orders().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
