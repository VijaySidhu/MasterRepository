package com.google.interview.design.lru;

import java.util.HashMap;

/**
 * Design and implement a data structure
 * for Least Recently Used (LRU) cache.
 * It should support the following
 * operations: get and set. get(key) -
 * Get the value (will always be
 * positive) of the key if the key
 * exists in the cache, otherwise return
 * -1. set(key, value) - Set or insert
 * the value if the key is not already
 * present. When the cache reached its
 * capacity, it should invalidate the
 * least recently used item before
 * inserting a new item.
 * 
 * An LRU Cache is usually implemented
 * by using a combination of a Hash
 * Table and a Linked List. The Hash
 * Table serves to enable quick lookup
 * and the (doubly linked) List serves
 * as the structure used to enable
 * location the least recently used item
 * for quick eviction
 * 
 * @author VijaySidhu
 *
 */
public class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	// Node is node of doubly linked list
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	public void remove(Node n) {
		// Set previous pointer's next to n next (coz we removing n)
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;

		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}
}
