package com.google.interview.questions.arrays;

import java.util.PriorityQueue;

/**
 * Average case time is O(n), worst case
 * is O(n*n) Quick Select algorithm
 * 
 * @author VijaySidhu
 *
 */
public class KthLargest {

	static public int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1, index = nums.length - k;
		while (start < end) {
			int pivot = partion(nums, start, end);
			if (pivot < index)
				start = pivot + 1;
			else if (pivot > index)
				end = pivot - 1;
			else
				return nums[pivot];
		}
		return nums[start];
	}

	static private int partion(int[] nums, int start, int end) {
		int pivot = start, temp;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot])
				start++;
			while (start <= end && nums[end] > nums[pivot])
				end--;
			if (start > end)
				break;
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		temp = nums[end];
		nums[end] = nums[pivot];
		nums[pivot] = temp;
		return end;
	}

	/**
	 * Min Heap Approach Time complexity
	 * is O(nlog(k)). Space complexity
	 * is O(k)
	 * 
	 * @param args
	 */

	static public int findKthLargestMinHeap(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);

			if (q.size() > k) {
				q.poll();
			}
		}

		return q.peek();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 10, 5 };
		// Quick Select
		System.out.println(findKthLargest(a, 4));
		// Min Heap
		System.out.println(findKthLargestMinHeap(a, 4));
	}

}
