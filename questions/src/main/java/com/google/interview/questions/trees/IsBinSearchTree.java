package com.google.interview.questions.trees;

/**
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author VijaySidhu
 *
 */
public class IsBinSearchTree {

	public static void main(String[] args) {
		BinarySearchTree t = BinarySearchTree.createBinarySearchTree();
		System.out.println(IsBinSearchTree.isValidBST(t, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
	}

	public static boolean isValidBST(BinarySearchTree node, double min, double max) {
		if (node == null) {
			return true;
		}
		if (node.data <= min || node.data >= max) {
			return false;
		}
		return isValidBST(node.left, min, max) && isValidBST(node.right, min, max);
	}

}
