package com.google.interview.questions.linkedlist;

import java.util.UUID;

/**
 * 1. Initialize result with first node
 * data 2. Initialize n = 2 3. Now one
 * by one consider all nodes from 2nd
 * node onward - Generate Random number
 * from 0 to n-1 - Let generated number
 * is j - if j==0 then choose other
 * fixed number between 0 to n-1 - n++
 * -current = current -- >
 * 
 * @author VijaySidhu
 *
 */
public class RandomNumberPickInSingleTraverse {

	// A reservoir sampling based function to print a
    // random node from a linked list
    static void printrandom(Node node) {
 
        // If list is empty
        if (node == null) {
            return;
        }
 
        // Use a different seed value so that we don't get
        // same result each time we run this program
        Math.abs(UUID.randomUUID().getMostSignificantBits());
 
        // Initialize result as first node
        int result = node.data;
 
        // Iterate from the (k+1)th element to nth element
        Node current = node;
        int n;
        for (n = 2; current != null; n++) {
 
            // change result with probability 1/n
            if (Math.random() % n == 0) {
                result = current.data;
            }
 
            // Move to next node
            current = current.next;
        }
 
        System.out.println("Randomly selected key is " + result);
    }
 

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		printrandom(head);
	}

}
