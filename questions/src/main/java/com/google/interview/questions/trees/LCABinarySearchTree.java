package com.google.interview.questions.trees;

public class LCABinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree node = BinarySearchTree.createBinarySearchTree();
		System.out.println(LCABinarySearchTree.lcaBST(node, 10, 20).data);
	}

	public static BinarySearchTree lcaBST(BinarySearchTree node, int data1, int data2) {

		if (data1 < node.data && data2 < node.data) {
			node = lcaBST(node.left, data1, data2);
			return node;
		}

		if (data1 > node.data && data2 > node.data) {
			node = lcaBST(node.right, data1, data2);
			return node;
		}

		return node;
	}

}
