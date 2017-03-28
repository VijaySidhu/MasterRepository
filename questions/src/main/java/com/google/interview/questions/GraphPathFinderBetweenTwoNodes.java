package com.google.interview.questions;

import java.util.LinkedList;

import com.google.interview.questions.GraphNode.Node;
import com.google.interview.questions.GraphNode.State;
/**
 * BFS
 * @author VijaySidhu
 *
 */
public class GraphPathFinderBetweenTwoNodes {

	public static void main(String[] args) {
		/**
		 * Add Nodes
		 */
		GraphNode graphNode = new GraphNode();
		GraphNode.Node node1 = graphNode.new Node(1, State.Unvisited);
		graphNode.addNode(node1);
		GraphNode.Node node2 = graphNode.new Node(2, State.Unvisited);
		graphNode.addNode(node2);
		GraphNode.Node node3 = graphNode.new Node(3, State.Unvisited);
		graphNode.addNode(node3);
		GraphNode.Node node4 = graphNode.new Node(4, State.Unvisited);
		graphNode.addNode(node4);
		GraphNode.Node node5 = graphNode.new Node(5, State.Unvisited);
		graphNode.addNode(node5);
		GraphNode.Node node6 = graphNode.new Node(6, State.Unvisited);
		graphNode.addNode(node6);
		/**
		 * Add Edges
		 */
		graphNode.addEdge(node1, node2);
		graphNode.addEdge(node2, node3);
		graphNode.addEdge(node3, node4);
		graphNode.addEdge(node5, node6);
		System.out.println("Test True Case::" + GraphPathFinderBetweenTwoNodes.searchRoute(graphNode, node1, node6));
		System.out.println("Test False Case::" + GraphPathFinderBetweenTwoNodes.searchRoute(graphNode, node1, node6));
	}

	public static boolean searchRoute(GraphNode g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList();
		if (start != null) {
			start.state = State.Visiting;
			q.add(start);
		}
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (null != u) {
				for (Node neighbour : g.getAdjNodes().get(u)) {
					if (neighbour.state == State.Unvisited) {
						if (neighbour == end) {
							return true;
						} else {
							neighbour.state = State.Visiting;
							q.add(neighbour);
						}
					}
				}

			}
			u.state = State.Visited;
		}
		return false;
	}

}
