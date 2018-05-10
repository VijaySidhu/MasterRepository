package com.google.interview.questions.trees;

class BinaryTee {

	int data;
	BinaryTee left;
	BinaryTee right;

	public BinaryTee(int data) {
		this.data = data;
	}

}

public class HeightorDepthBinaryTree {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		System.out.println(HeightorDepthBinaryTree.findHeight(root));
	}

	public static int findHeight(BinaryTree node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = findHeight(node.left);
		int rightDepth = findHeight(node.right);
		if (leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}

	}

}
