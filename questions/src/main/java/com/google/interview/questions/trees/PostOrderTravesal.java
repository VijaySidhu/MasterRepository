package com.google.interview.questions.trees;

public class PostOrderTravesal {

	void printPostOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.key);
	}

	void printInOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		printInOrder(node.left);
		System.out.println(node.key + " ");
		printInOrder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(TreeNode node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Driver method
	public static void main(String[] args) {
		PostOrderTravesal obj = new PostOrderTravesal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal of binary tree is ");
		obj.printPreorder(root);

		System.out.println("Inorder traversal of binary tree is ");
		obj.printInOrder(root);

		System.out.println("Postorder traversal of binary tree is ");
		obj.printPostOrder(root);
	}

}
