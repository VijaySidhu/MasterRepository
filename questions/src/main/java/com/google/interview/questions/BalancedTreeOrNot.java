package com.google.interview.questions;

public class BalancedTreeOrNot {

	public static void main(String[] args) {
		System.out.println(BalancedTreeOrNot.isBalancedTree(BalancedTreeOrNot.getBalancedTree()));
	}

	private static boolean isBalancedTree(Tree node) {
		if (node == null) {
			return false;
		}
		int height = getHeight(node);
		if (height == -1) {
			return false;
		}
		return true;
	}

	/**
	 * If tree is not empty then Height = 1+ Max of LeftHeight+RightHeight
	 * 
	 * @param node
	 * @return
	 */
	public static int getHeight(Tree node) {

		if (node == null) {
			return 0;
		}
		// check if left sub-tree is balanced
		int left = getHeight(node.getLeftChild());
		// check if right sub-tree is balanced
		int right = getHeight(node.getRightChild());

		if (left == -1 || right == -1) {
			return -1;
		}

		// if both sub-trees are balanced, check the difference of heights
		// should be less than or equal to 1 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		// if tree rooted at this node is balanced, return height if tree rooted at this this node
		return Math.max(left, right) + 1;

	}

	/**
	 * nodes= 2^H-1 where h is height of tree
	 * 
	 * @return
	 */

	private static Tree getBalancedTree() {
		Tree rootNode1 = new Tree(1);
		Tree rootNode2 = new Tree(2);
		Tree rootNode3 = new Tree(3);
		Tree rootNode4 = new Tree(4);
		Tree rootNode5 = new Tree(5);
		Tree rootNode6 = new Tree(6);
		Tree rootNode7 = new Tree(7);
		rootNode1.setLeftChild(rootNode2);
		rootNode1.setRightChild(rootNode3);
		rootNode2.setLeftChild(rootNode4);
		rootNode2.setRightChild(rootNode5);
		rootNode3.setRightChild(rootNode6);
		rootNode5.setLeftChild(rootNode7);
		return rootNode1;
	}

}
