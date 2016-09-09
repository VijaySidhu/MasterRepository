package com.google.interview.questions.trees;

public class BinarySearchTree {

	int data;
	BinarySearchTree left;
	BinarySearchTree right;

	public BinarySearchTree(int data) {
		this.data = data;

	}

	public static BinarySearchTree createBinarySearchTree() {
		BinarySearchTree rootNode = new BinarySearchTree(30);
		BinarySearchTree node10 = new BinarySearchTree(10);
		BinarySearchTree node20 = new BinarySearchTree(20);
		BinarySearchTree node25 = new BinarySearchTree(25);
		BinarySearchTree node35 = new BinarySearchTree(35);
		BinarySearchTree node40 = new BinarySearchTree(40);
		BinarySearchTree node50 = new BinarySearchTree(50);
		BinarySearchTree node60 = new BinarySearchTree(60);
		rootNode.left = node20;
		rootNode.right = node40;
		node20.left = node10;
		node20.right = node25;
		node40.left = node35;
		node40.right = node50;
		node50.right = node60;
		return rootNode;
	}

}
