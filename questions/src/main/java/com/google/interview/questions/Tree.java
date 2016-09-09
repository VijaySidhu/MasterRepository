package com.google.interview.questions;

public class Tree {

	private int value;

	private Tree leftChild;

	private Tree rightChild;

	Tree(int value) {
		this.value = value;
	}

	public Tree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Tree leftChild) {
		this.leftChild = leftChild;
	}

	public Tree getRightChild() {
		return rightChild;
	}

	public void setRightChild(Tree rightChild) {
		this.rightChild = rightChild;
	}

}
