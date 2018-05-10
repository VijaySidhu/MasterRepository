package com.google.interview.questions.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Adjacency Matrix(AM) 2. Adjacency
 * list(AL) Basic operations : Add Edge,
 * AM:: O(1) AL::O(log(n)); delete Edge,
 * AM:: O(1) AL::O(log(n)); Is there
 * edge between i and j AM:: O(1)
 * AL::O(log(n)); find successor of
 * given vertex AM :: O(n) AL::O(k));
 * find path between vertices AM ::
 * O(n*n) (n+m)
 * 
 * @author VijaySidhu
 */
public class Graph {

	Map<Node, List<Node>> adjList = new HashMap<Node, List<Node>>();

	List<Node> nodes = new ArrayList<Node>();

	/**
	 * @param node
	 */
	public void addNode(Node node) {
		nodes.add(node);
		adjList.put(node, new ArrayList<Node>());
	}

	public void addEdge(Node u, Node v) {
		if (adjList.containsKey(u) && adjList.containsKey(v)) {
			List<Node> neighbour = adjList.get(u);
			neighbour.add(v);
		}
	}

	public Map<Node, List<Node>> getAdjList() {
		return adjList;
	}

	public void setAdjList(Map<Node, List<Node>> adjList) {
		this.adjList = adjList;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

}
