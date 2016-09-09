package com.google.interview.questions;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary tree with minimal height.
 * 
 * @author VijaySidhu
 *
 */
public class ArrayToBSTMinimalHeight {

	class TreeNode {

		int element;
		TreeNode left;
		TreeNode right;

		public TreeNode(int element) {
			this.element = element;

		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		ArrayToBSTMinimalHeight bst = new ArrayToBSTMinimalHeight();
		TreeNode treeNode= bst.createMinimalBST(arr, bst);

	}

	public static TreeNode createMinimalBST(int[] arr, ArrayToBSTMinimalHeight bst) {
		return addToTree(arr, 0, arr.length - 1, bst);
	}

	public static TreeNode addToTree(int arr[], int start, int end, ArrayToBSTMinimalHeight bst) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;

		ArrayToBSTMinimalHeight.TreeNode n = bst.new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid - 1, bst);
		n.left = addToTree(arr, mid + 1, end, bst);
		return n;
	}

}
