package com.google.interview.questions.trees;

public class DeleteTree {

	void deleteTree(TreeNode node) {
		if (node == null) {
			return;
		}

		deleteTree(node.left);
		deleteTree(node.right);
		System.out.println("Deleted Node ::" + node.key);
		node = null;
	}

	public static void main(String[] args) {
		DeleteTree delTree = new DeleteTree();
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
		delTree.deleteTree(rootNode);
	}

}
