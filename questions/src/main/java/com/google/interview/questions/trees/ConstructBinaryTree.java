package com.google.interview.questions.trees;

/**
 * It can be done given travesal order. It can be done if given order in inOrder
 * 
 * @author VijaySidhu
 *
 */

public class ConstructBinaryTree {

	static int preIndex = 0;

	StringTreeNode buildTree(char in[], char pre[], int inStrt, int inEnd) {

		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		StringTreeNode tNode = new StringTreeNode(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.data);
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		return tNode;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Function to find index of value in arr[start...end] The function assumes
	 * that value is present in in[]
	 */
	int search(char arr[], int strt, int end, char value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	void printInOrder(StringTreeNode node) {
		if (node == null) {
			return;
		}

		printInOrder(node.left);
		System.out.println(node.data + " ");
		printInOrder(node.right);
	}

	public static void main(String[] args) {

		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };

		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };

		int len = in.length;

		ConstructBinaryTree cbt = new ConstructBinaryTree();
		StringTreeNode nd = cbt.buildTree(in, pre, 0, len - 1);
		cbt.printInOrder(nd);

	}

}
