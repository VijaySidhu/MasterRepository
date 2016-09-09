package com.google.interview.questions;

import java.util.Stack;

/**
 * PreOrder means we will read Node first then Left and Right childrens
 * 
 * @author VijaySidhu
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		TreeNode rootNode = BinaryTreeCreation.createBinaryTree();
		System.out.println("Using Recursive solution:");
		binaryTree.preOrder(rootNode);
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Using Iterative solution:");
		binaryTree.preOrderIter(rootNode);
	}

	public static class TreeNode {
		/**
		 * data is Root Node
		 */
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}

		public int getData() {
			return data;
		}

	}

	// Recursive Solution
	public void preOrder(TreeNode root) {
		if (null != root) {
			System.out.println("Value of Root::" + root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// Iterative Solution
	public void preOrderIter(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode n = stack.pop();
			System.out.printf("%d ", n.data);
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	
}
