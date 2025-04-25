package networkflow.java.model;

/**
 * Represents an edge in a flow network with source, destination, capacity, and flow
 * source - starting node
 * destination - ending node
 * capacity - maximum amount of flow that can pass through an edge from the source to destination
 * flow - actual amount of resources that is passing through an edge in the network
 */
public class Edge {
    private final int source;
    private final int destination;
    private final int capacity;
    private int flow;

    /**
     * constructs a new edge with the given source, destination and capacity
     * @param source  the starting node (source node)
     * @param destination  the ending node (destination node)
     * @param capacity  the maximum amount of flow that can pass through an edge
     */
    public Edge(int source, int destination, int capacity) {
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.flow = 0;
    }

    /**
     * Returns the source node of this edge
     * @return the source node
     */
    public int getSource() {
        return source;
    }

    /**
     * Returns the destination node of this edge
     * @return the destination node
     */
    public int getDestination() {
        return destination;
    }

    /**
     * Returns the capacity of the edge
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the current flow through this edge
     * @return the current flow
     */
    public int getFlow() {
        return flow;
    }

    /**
     * sets the flow through this edge
     * @param flow the new flow value
     */
    public void setFlow(int flow) {
        this.flow = flow;
    }

    /**
     * Returns the remaining capacity of this edge
     * @return the remaining capacity(redualcapacity)
     */
    public int getResidualCapacity(){
        return capacity-flow;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "SOURCE -> " + source +
                ", destination (" + destination +
                ", flow / " + flow +
                ", capacity=" + capacity +
                '}';
    }
}
