package com.google.interview.questions.trees;

import com.google.interview.questions.TreeNode;

/**
 * Approach similar to approach for Common ancestor for BST. Keep going down on
 * one side(right or left) if both the nodes are in the same side(right or
 * left), else the current node is the lowest common ancestor
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
		treeNodeC.setRight(treeNodeF);
		TreeNode result = b.commonAncestor(treeNodeA, treeNodeB, treeNodeC);
		System.out.println("Lowest Common Ancestor " + result.getData());
	}

	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 1st check if p and q, both belong to the left of the current root node, if yes then recurse on the left side
		if (covers(root.getLeft(), p) && covers(root.getLeft(), q)) // check out the covers subroutine, can be used elsewhere too!
			return commonAncestor(root.getLeft(), p, q);
		// else, check if both p and q are children of right side of the root, if yes, then recurse on the right side
		if (covers(root.getRight(), p) && covers(root.getRight(), q))
			return commonAncestor(root.getRight(), p, q);
		return root; // lowest Common Ancestor.
	}

	private boolean covers(TreeNode root,
			TreeNode p) { /* is p a child of root? */
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.getLeft(), p) || covers(root.getLeft(), p); // recursively check if p is a child of right.
	}
}
