package networkflow.java.model;

/**
 * Represents an edge in a flow network with source, destination, capacity, and flow
 * source - starting node
 * destination - ending node
 * capacity - maximum amount of flow that can pass through an edge from the source to destination
 * flow - actual amount of resources that is passing through an edge in the network
 */
public class Edge {
    private final int source;          //  Source node of the edge
    private final int destination;     //  Destination node of the edge
    private final int capacity;        //  Maximum flow capacity of the edge
    private int flow;                  //  Current flow through this edge  ( 0 )

    /**
     * Constructs a new edge with the given source, destination and capacity
     * @param source        The starting node (source node)
     * @param destination   The ending node (destination node)
     * @param capacity      The maximum amount of flow that can pass through an edge
     */
    public Edge(int source, int destination, int capacity) {
        this.source      = source;
        this.destination = destination;
        this.capacity    = capacity;
        this.flow        = 0;
    }

    /**
     * Returns the source node of this edge
     * @return The source node
     */
    public int getSource() {
        return source;
    }

    /**
     * Returns the destination node of this edge
     * @return The destination node
     */
    public int getDestination() {
        return destination;
    }

    /**
     * Returns the capacity of the edge
     * @return The capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the current flow through this edge
     * @return The current flow
     */
    public int getFlow() {
        return flow;
    }

    /**
     * sets the flow through this edge
     * @param flow The new flow value
     */
    public void setFlow(int flow) {
        this.flow = flow;
    }

    /**
     * Returns the remaining capacity of this edge
     * @return The remaining capacity(redualcapacity)
     */
    public int getResidualCapacity(){
        return capacity-flow;
    }

    /**
     * Returns a string representation of this edge
     * @return A string source, destination, flow and capacity
     */
    @Override
    public String toString() {
        return source + " -> " + destination + " (" + flow + "/" + capacity + ")";
    }
}
