package com.google.interview.questions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {

	public void levelOrderQueue(TreeNode root) {
		Queue q = new LinkedList<>();
		int levelNodes = 0;
		if (root == null)
			return;
		q.add(root);

		while (!q.isEmpty()) {
			levelNodes = q.size();
			while (levelNodes > 0) {
				TreeNode node = (TreeNode) q.remove();
				System.out.print(" " + node.key);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				levelNodes--;
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(1);
		TreeNode rootNode1 = new TreeNode(2);
		TreeNode rootNode2 = new TreeNode(3);
		TreeNode rootNode3 = new TreeNode(4);
		TreeNode rootNode4 = new TreeNode(5);
		TreeNode rootNode5 = new TreeNode(6);
		rootNode.left = rootNode1;
		rootNode.right = rootNode2;
		rootNode1.left = rootNode3;
		rootNode1.right = rootNode4;
		rootNode2.left = rootNode5;
		rootNode2.right = rootNode5;
		LevelOrderLineByLine lineByLine = new LevelOrderLineByLine();
		lineByLine.levelOrderQueue(rootNode);
	}

}
