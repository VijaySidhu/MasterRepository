package com.google.interview.questions.trees;

import com.google.interview.questions.TreeNode;

/**
 * 1. If all are null return null 
 * 2. If data at root is same as data at node1 return root 
 * 3. If data at root is same as data at node2 return root
 * 4. Recurse Left and Righ subtree if left and right are not null return root
 * 5. If left is not null return left
 * 6. If right is not null return right
 * 
 */

public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		LowestCommonAncestorBinaryTree b = new LowestCommonAncestorBinaryTree();
		com.google.interview.questions.TreeNode treeNodeA = new com.google.interview.questions.TreeNode('a');
		com.google.interview.questions.TreeNode treeNodeB = new com.google.interview.questions.TreeNode('b');
		com.google.interview.questions.TreeNode treeNodeC = new com.google.interview.questions.TreeNode('c');
		com.google.interview.questions.TreeNode treeNodeD = new com.google.interview.questions.TreeNode('d');
		com.google.interview.questions.TreeNode treeNodeE = new com.google.interview.questions.TreeNode('e');
		com.google.interview.questions.TreeNode treeNodeF = new com.google.interview.questions.TreeNode('f');
		com.google.interview.questions.TreeNode treeNodeG = new com.google.interview.questions.TreeNode('g');
		treeNodeA.setLeft(treeNodeB);
		treeNodeA.setRight(treeNodeC);
		treeNodeB.setLeft(treeNodeD);
		treeNodeB.setRight(treeNodeE);
		treeNodeC.setLeft(treeNodeF);
		treeNodeC.setRight(treeNodeG);
		TreeNode result = b.lowestCommonAncestor(treeNodeA, treeNodeD, treeNodeE);
		System.out.println("Lowest Common Ancestor " + result.getData());
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}
		if (root.getData() == A.getData()) {
			return root;
		}
		if (root.getData() == B.getData()) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.getLeft(), A, B);
		TreeNode right = lowestCommonAncestor(root.getRight(), A, B);
		if (left != null && right != null) {
			return root;
		}

		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}
		return null;
	}
}
