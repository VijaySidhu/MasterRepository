package com.google.interview.questions;

public class TreeNode {

	char data;

	TreeNode left;

	TreeNode right;

	public TreeNode(char character) {
		this.data = character;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public char getData() {
		return data;
	}

}
