package networkflow.java.model;

/**
 * Represents an edge in a flow network with source, destination, capacity, and flow
 * source - starting node
 * destination - ending node
 * capacity - maximum amount of flow that can pass through an edge from the source to destination
 * flow - actual amount of resources that is passing through an edge in the network
 */
public class Edge {
    private final int SOURCE;
    private final int DESTINATION;
    private final int CAPACITY;
    private int flow;

    /**
     * constructs a new edge with the given source, destination and capacity
     * @param SOURCE  the starting node (source node)
     * @param DESTINATION  the ending node (destination node)
     * @param CAPACITY  the maximum amount of flow that can pass through an edge
     */
    public Edge(int SOURCE, int DESTINATION, int CAPACITY) {
        this.SOURCE = SOURCE;
        this.DESTINATION = DESTINATION;
        this.CAPACITY = CAPACITY;
        this.flow = 0;
    }

    /**
     * Returns the source node of this edge
     * @return the source node
     */
    public int getSOURCE() {
        return SOURCE;
    }

    /**
     * Returns the destination node of this edge
     * @return the destination node
     */
    public int getDESTINATION() {
        return DESTINATION;
    }

    /**
     * Returns the capacity of the edge
     * @return the capacity
     */
    public int getCAPACITY() {
        return CAPACITY;
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
        return CAPACITY-flow;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "SOURCE -> " + SOURCE +
                ", DESTINATION (" + DESTINATION +
                ", flow / " + flow +
                ", CAPACITY=" + CAPACITY +
                '}';
    }
}
