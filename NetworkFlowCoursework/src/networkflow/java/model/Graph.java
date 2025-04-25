package networkflow.java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flow network as a directed graph with capacities on edges
 */
public class Graph {
        private final int numNodes;
        private final List<Edge>[] adjacencyList;
        private final List<Edge> edges;

    /**
     * constructs a new graph with the given number of nodes
     */
    @SuppressWarnings("uncheked")

    public Graph(int numNodes, List<Edge>[] adjacencyList, List<Edge> edges) {
        this.numNodes = numNodes;
        this.adjacencyList = new ArrayList[numNodes];
        this.edges = new ArrayList<>();

        // initialize adjacency list for all nodes
        for(int i=0; i<numNodes; i++){
            adjacencyList[i]=new ArrayList<>();
        }
    }

    /**
     * Returns the number of nodes in the graph
     * @return the number of nodes
     */
    public int getNumNodes() {
        return numNodes;
    }

    /**
     * adds a directed edge to the graph with the given capacity
     * @param source the source node
     * @param destination  the destination node
     * @param capacity  the capacity of the edge
     */
    public void addEdge(int source, int destination, int capacity){
        // create a forward edge
        Edge edge = new Edge(source, destination, capacity);
        adjacencyList[source].add(edge);
        edges.add(edge);

        // create a backward edge with zero capacity
        // used for the residual graph in Ford-Fulkerson
        Edge reverseEdge = new Edge(destination, source, 0);
        adjacencyList[destination].add(reverseEdge);
        edges.add(reverseEdge);
    }

    /**
     * Gets all edges in the graph
     * @return List of all edges
     */
    public List<Edge> getAllEdges(){
        return edges;
    }

    /**
     * Finds an edge from source to destination if it exists
     * @param source the source node
     * @param destination   the destination node
     * @return  the edge or null if not found
     */
    public Edge findEdge(int source, int destination){
        for(Edge edge : adjacencyList[source]){
            if(edge.getDestination() == destination){
                return edge;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Graph with ").append(numNodes).append(" nodes:/n");

        for(int i = 0; i < numNodes; i++){
            sb.append("Node ").append(i).append(" edges: ");
            for(Edge edge : adjacencyList[i]){
                if(edge.getCapacity() > 0){
                    // only show edges with capacity
                    sb.append(edge).append(", ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }






}
