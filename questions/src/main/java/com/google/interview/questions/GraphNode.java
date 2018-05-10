package com.google.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {


	private Map<Node, ArrayList<Node>> adjNodes = new HashMap();

	private List<Node> nodes = new ArrayList();

	private int numberOfEdges;

	public class Node {
		int element;
		State state;
		Node(int element, State state) {
			this.element = element;
			this.state = state;
		}

	}

	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public Map<Node, ArrayList<Node>> getAdjNodes() {
		return adjNodes;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
		adjNodes.put(node, new ArrayList<Node>());
	}

	public void addEdge(Node u, Node v) {
		if (adjNodes.containsKey(u) && adjNodes.containsKey(v)) {
			ArrayList<Node> neighbours = adjNodes.get(u);
			neighbours.add(v);
			++numberOfEdges;
		} else {
			throw new IllegalArgumentException("Bad Request");
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}

	
}
