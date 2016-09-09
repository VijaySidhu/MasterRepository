package com.google.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private int numberOfVertices;
	private int numberOfEdges;
	
	/*
	 * Map Of
	 */
	private Map<Integer, ArrayList<Integer>> adjListsMap = new HashMap<>();

	public int addVertex() {
		adjListsMap.put(++numberOfEdges, new ArrayList<>());
		return numberOfVertices;
	}

	public void addEdge(int u, int v) {
		if (adjListsMap.containsKey(u) && adjListsMap.containsKey(v)) {
			++numberOfEdges;
			ArrayList<Integer> neighbours = adjListsMap.get(u);
			neighbours.add(v);
		} else
			throw new IllegalArgumentException("Bad Request");
	}
	 public List<Integer> getNeighbors(int vertex){
	        return adjListsMap.get(vertex);
	    }
}
