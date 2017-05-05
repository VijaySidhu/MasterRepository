package com.google.interview.questions.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.google.interview.questions.linkedlist.Node;

/**
 * Time Complexity: Time complexity of the above solution is O(n) where n is the number of nodes
 * Create Empty Queue Add first Node of
 * linked list to queue Loop until we
 * reach at end of linked list 1. Dqueue
 * first node of queue 2. Traverse 2
 * nodes of list add it to queue
 * 
 * @author VijaySidhu
 *
 */

public class LinkedListToBinaryTree {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.setNext(new Node(2));
		head.getNext().setNext(new Node(3));
		head.getNext().getNext().setNext(new Node(4));
		TreeNode tree = convertListToBinTree(head);
		inOrder(tree);

	}

	private static void inOrder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		inOrder(tree.left);
		System.out.println(tree.key);
		inOrder(tree.right);

	}

	public static TreeNode convertListToBinTree(Node head) {
		if (head == null) {
			return null;
		}
		// Create first Tree Node with first Element of LinkedList
		TreeNode node = new TreeNode(head.getData());
		// Add Tree Node to Queue
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		// Move head to next element
		head = head.getNext();
		// Loop until last element of linked list
		while (head != null) {
			TreeNode parent = queue.poll();
			// Take next two nodes from linked list and set as left and right child
			TreeNode leftChild = new TreeNode(head.getData());
			TreeNode rightChild = null;
			queue.add(leftChild);
			head = head.getNext();
			if (head != null) {
				rightChild = new TreeNode(head.getData());
				queue.add(rightChild);
				head = head.getNext();
			}
			parent.left = leftChild;
			parent.right = rightChild;

		}
		return node;
	}

}
