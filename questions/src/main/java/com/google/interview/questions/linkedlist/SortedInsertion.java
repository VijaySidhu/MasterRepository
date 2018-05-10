package com.google.interview.questions.linkedlist;

public class SortedInsertion {

	Node head;

	public void sortedInsert(Node newNode) {
		Node current;
		if (head == null || head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		} else {
			/**
			 * Locate node before point of insertion
			 */
			current = head;
			while (current.next != null && current.next.data < newNode.data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
    Node newNode(int data)
    {
       Node x = new Node(data);
       return x;
    }
 
     /* Function to print linked list */
     void printList()
     {
         Node temp = head;
         while (temp != null)
         {
            System.out.print(temp.data+" ");
            temp = temp.next;
         }
     }
 
     /* Drier function to test above methods */
     public static void main(String args[])
     {
    	 SortedInsertion llist = new SortedInsertion();
         Node new_node;
         new_node = llist.newNode(5);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(10);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(7);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(3);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(1);
         llist.sortedInsert(new_node);
         new_node = llist.newNode(9);
         llist.sortedInsert(new_node);
         System.out.println("Created Linked List");
         llist.printList();
     }
}
