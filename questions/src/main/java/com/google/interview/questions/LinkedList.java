package com.google.interview.questions;

public class LinkedList {
	/**
	 * Represent Head Of List
	 */
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * Insert New Node at Front of list
	 */
	public void push(int newData) {
		/**
		 * Allocate Node and Put in data
		 */
		Node newNode = new Node(newData);
		/**
		 * Make Next of new Node as Head
		 */
		newNode.next = head;
		/**
		 * Move head to point new node
		 */

		head = newNode;

	}

	/**
	 * Find Nth Element from End Of List
	 */
	 /* Function to get the nth node from end of list */
    void printNthFromLast(int n)
    {
        Node main_ptr = head;
        Node ref_ptr = head;
 
        int count = 0;
        if (head != null)
        {
            while (count < n)
            {
                if (ref_ptr == null)
                {
                    System.out.println(n+" is greater than the no "+
                                      " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
            while (ref_ptr != null)
            {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. "+n+" from last is "+
                               main_ptr.data);
        }
    }
    /**
     * Delete Node in middle of list Pointer is given
     */
    public void deleteNode(Node node){
    	Node temp = node.next;
    	node.data=temp.data;
    	node.next=temp.next;
    }

}
