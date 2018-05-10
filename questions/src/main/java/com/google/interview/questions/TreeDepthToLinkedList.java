package com.google.interview.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import com.google.interview.questions.ArrayToBSTMinimalHeight.TreeNode;

public class TreeDepthToLinkedList {

	public static void main(String[] args) {
		TreeDepthToLinkedList deptList = new TreeDepthToLinkedList();
		TreeNode root = deptList.new TreeNode(1);
		root.left = deptList.new TreeNode(2);
		root.right = deptList.new TreeNode(3);
		deptList.findLevelLinkedList(root);
	}

	/**
	 * We need to track on which level we are in
	 * 
	 * @param root
	 */
	public ArrayList<LinkedList<TreeNode>> findLevelLinkedList(TreeNode root) {
		int level = 0;

		ArrayList<LinkedList<TreeNode>> result = new ArrayList();

		LinkedList<TreeNode> list = new LinkedList();
		list.add(root);
		result.add(level, list);
		while (true) {
			list = new LinkedList<TreeNode>();
			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode n = (TreeNode) result.get(level).get(i);
				if (null != n) {
					if (n.left != null)
						list.add(n.left);
					if (n.right != null) {
						list.add(n.right);
					}
				}
				if (list.size() > 0) {
					result.add(level + 1, list);
				} else {
					break;
				}
				level++;
			}
			return result;
		}
	}

	class TreeNode {
		int element;
		TreeNode left;
		TreeNode right;

		public TreeNode(int element) {
			this.element = element;
		}
	}

}