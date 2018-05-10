package com.google.interview.questions.trees;

public class DisplayTree {

	public static void display(BinarySearchTree node) {

		if (node == null) {
			return;
		} else {
			display(node.left);
			System.out.println(" " + node.data + " ");
			display(node.right);
		}

	}

}
