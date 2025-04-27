package networkflow.java.algorithm;

import networkflow.java.model.Edge;
import networkflow.java.model.Graph;

import java.util.*;

/**
 * Implementation of the Ford-Fulkerson algorithm using BFS
 * for finding maximum flow in a network flow problem
 */
public class MaxFlowAlgorithm {
    private final Graph graph;
    private List<String> steps;

    /**
     * constructs a new Ford-Fulkerson algorithm instance for the given graph
     *
     * @param graph the flow network graph
     */
    public MaxFlowAlgorithm(Graph graph) {
        this.graph = graph;
        this.steps = new ArrayList<>();
    }

    /**
     * finds the maximum flow from source to sink using the Ford-Fulkerson algorithm
     * Uses BFS to find augmenting paths
     *
     * @param source The source node
     * @param sink The sink node
     * @return The maximum flow value
     */
    public int findMaxFlow(int source, int sink) {
        int maxFlow = 0;

        // record the starting state
        steps.add("Starting Ford-Fulkerson algorithm with zero flow");
        steps.add(getCurrentFlowState());

        // keep finding augmenting paths and adding flow
        int iteration = 1;
        int[] parent = new int[graph.getNumNodes()];

        while (findAugmentingPath(source, sink, parent)) {
            // finding the bottleneck capacity along the path
            int pathFlow = Integer.MAX_VALUE;
            StringBuilder pathDescription = new StringBuilder();

            // start from sink and go backwards to source
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                Edge edge = graph.findEdge(u, v);
                pathFlow = Math.min(pathFlow, edge.getResidualCapacity());

                if (v != sink) {
                    pathDescription.insert(0, " -> ");
                }
                pathDescription.insert(0, v);
                if (v == parent[source]) {
                    pathDescription.insert(0, source + " -> ");
                }
            }

            // update flow values along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];

                // forward edge - add flow
                Edge edge = graph.findEdge(u, v);
                edge.setFlow(edge.getFlow() + pathFlow);

                // backend edge - substract flow
                Edge backEdge = graph.findEdge(v, u);
                backEdge.setFlow(backEdge.getFlow() - pathFlow);
            }

            // add to max flow
            maxFlow += pathFlow;

            // record this iteration
            steps.add("\nIteration " + iteration + ":");
            steps.add("Found augmenting path: " + pathDescription);
            steps.add("Bottleneck capacity: " + pathFlow);
            steps.add("Flow after this iteration: " + maxFlow);
            steps.add(getCurrentFlowState());

            iteration++;
        }

        steps.add("\nFinal maximum flow: " + maxFlow);
        steps.add("No more augmenting paths found. Algorithm terminates");

        return maxFlow;
    }

    /**
     * Finds an augmenting path source to sink using BFS
     *
     * @param source  The source node
     * @param sink    The sink node
     * @param parent  Array to store the path
     * @return true if an augmenting path exists, false otherwise
     */
    private boolean findAugmentingPath(int source, int sink, int[] parent) {
        int numNodes = graph.getNumNodes();
        boolean[] visited = new boolean[numNodes];

        // initialize all nodes as not visited
        Arrays.fill(visited, false);

        // create a queue for BFS and add source
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        //BFS Loop
        while (!queue.isEmpty()) {
            int u = queue.poll();

            // chack all adjacent noded of the dequeued node
            for(Edge edge : graph.getEdgesFrom(u)) {
                int v = edge.getDestination();

                // if not visited and has residual capacity
                if (!visited[v] && edge.getResidualCapacity() > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // if we reached sink in BFS, then there is a path
        return visited[sink];
    }

    /**
     * Gets the current state of all flows in the graph as a formatted String
     *
     * @return  String representing current flows
     */
    private String getCurrentFlowState(){
        StringBuilder sb = new StringBuilder("current flow state:\n");

        for(int i = 0; i < graph.getNumNodes(); i++){
            for(Edge edge : graph.getAllEdges()){
                // only show edges with positive capacity
                if(edge.getCapacity() > 0) {
                    sb.append(" Edge ").append(edge.getSource())
                            .append(" -> ").append(edge.getDestination())
                            .append(": Flow = ").append(edge.getFlow())
                            .append("/").append(edge.getCapacity())
                            .append("\n");
                }
            }
        }

        return sb.toString();
    }

    /**
     * Gets the detailed steps of the algorithm execution
     *
     * @return List of Strings describing each step
     */
    public List<String> getSteps(){
        return steps;
    }

}
