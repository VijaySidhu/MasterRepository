package com.google.interview.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a graph and a source node and destination node, find the number of
 * shortest paths present between source and destination. Hint: Use BFS
 * 
 * If it is unweighted and undirectional graph it can be done in  O(N) using BFS
 * 
 * 1. Add Visited Node into Queue
 * 2. Once path is found Queue will have mutliple destination node with distance from source 
 * 
 * @author VijaySidhu
 *
 */
public class AllShortestPathInGraph {

	public static int getNumberOfShortestPath(Graph graph,int source,int destination){

        class QueueNode{
            Integer vertex;
            Integer distance;

            public QueueNode(Integer vertex, Integer distance) {
                this.vertex = vertex;
                this.distance = distance;
            }
        }

        int shortestDistance =0;
        Deque<QueueNode> deque = new LinkedList<>();
        int shortestPath = 0;
        boolean found = false;
        deque.add(new QueueNode(source,0));

        while (!deque.isEmpty()){
            QueueNode node = deque.remove();
            for (Integer neighbor : graph.getNeighbors(node.vertex)) {
                if(neighbor.equals(destination)){
                    if (!found) {
                        found = true;
                        shortestDistance = node.distance + 1;
                        shortestPath++;
                    }
                    else if (shortestDistance==node.distance+1){
                        shortestPath++;
                    }
                }
                if (!found){
                    deque.add(new QueueNode(neighbor,node.distance+1));
                }
            }
        }
        return shortestPath;
    }

    public static void main(String[] a) {
        Graph graph = new Graph();
        for (int i = 0; i < 5; i++) {
            graph.addVertex();
        }
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println(getNumberOfShortestPath(graph,1,5));
    }}
