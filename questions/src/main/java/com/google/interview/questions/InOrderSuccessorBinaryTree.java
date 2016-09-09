package com.google.interview.questions;

public class InOrderSuccessorBinaryTree {

	public static TreeNode n = null;

	public static Boolean nodeFound = false;

	public InOrderSuccessorBinaryTree() {
	}

	public TreeNode InOrderSuccessorBinaryTree(TreeNode root, TreeNode x) {
		nodeFound = false;
		if (x.right != null) {
			/**
			 * Then Left Most node of right subtree is successor
			 */
			TreeNode temp = leftMostTreeNode(x.right);
			System.out.println("The In Order Successor for '" + x.data + "' is " + temp.data);
			return null;
		}
		return findRecur(root, x);
	}

	/**
	 * Start from the root and com­pare it with x, if matched then we have found
	 * the node. else go left and right. recur­sively do step 2 and 3 till you
	 * find the node x. Now when you have found the node, stop the recursion.
	 * Now recur­sion will back­track to the root, every recur­sive call will
	 * return the node itself (say it will be stored in n) so when it
	 * back­tracked to its par­ent which will be root now, check whether
	 * parent.left = n, if not , keep going up.
	 * 
	 * @param root
	 * @param x
	 * @return
	 */
	public TreeNode findRecur(TreeNode root, TreeNode x) {
		if (root == null)
			return null;
		if (root == x || (n = findRecur(root.left, x)) != null || (n = findRecur(root.right, x)) != null) {
			if (n != null) {
				if (root.left == n) {
					nodeFound = true;
					System.out.println("The In Order Successor for '" + x.data + "' is " + root.data);
					return null;
				}
			}
			return root;
		}
		return null;
	}

	public TreeNode leftMostTreeNode(TreeNode x) {
		while (x.left != null) {
			x = x.left;
		}
		nodeFound = true;
		return x;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode('a');
		root.left = new TreeNode('b');
		root.right = new TreeNode('c');
		root.left.left = new TreeNode('d');
		root.left.right = new TreeNode('e');
		TreeNode x = new TreeNode('x');
		root.left.right.left = new TreeNode('i');
		root.left.right.left.right = new TreeNode('j');
		root.left.right.left.right.right = x;
		root.right.left = new TreeNode('f');
		TreeNode y = new TreeNode('g');
		root.right.right = y;

		InOrderSuccessorBinaryTree i = new InOrderSuccessorBinaryTree();
		System.out.print(" Tree : ");
		i.display(root);
	}

	public void display(TreeNode root) {
		if (null != root) {
			display(root.left);
			System.out.println(root.data);
			display(root.right);

		}
	}
}
