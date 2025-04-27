package networkflow.java.util;

import networkflow.java.model.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Parser for reading network flow problems from input files or strings
 *
 */
public class NetworkParser {

    /**
     * Parses a network flow problem from a file and creates a Graph object
     * File format:
     * -First line: number of nodes
     * -Each subsequent line: three integers a b c representing an edge from node
     * a to node b with capacity c
     *
     * @param filename   The path to the input file
     * @return A Graph object representing the network
     * @throws IOException  If there's an error reading the file
     */
    public static Graph parseFromFile(String filename) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            // Read number of nodes
            int numNodes = Integer.parseInt(reader.readLine().trim());
            Graph graph = new Graph(numNodes);

            // read edges
            String line;
            while((line = reader.readLine()) != null){
                // skip empty lines
                if(line.trim().isEmpty()){
                    continue;
                }

                // parse the edge: source destination capacity
                String[] parts = line.trim().split("\\s+");
                if(parts.length<3){
                    throw  new IOException("Invalid edge format: " + line);
                }

                try{
                    int source = Integer.parseInt(parts[0]);
                    int destination = Integer.parseInt(parts[1]);
                    int capacity = Integer.parseInt(parts[2]);

                    // validate node indices
                    if(source<0 || source>=numNodes || destination < 0 || destination >= numNodes){
                        throw new IOException("Invalid node index in line: " + line);
                    }

                    // valid capacity
                    if(capacity<0){
                        throw new IOException("Invalid node index in line: " + line);
                    }

                    // add edge to graph
                    graph.addEdge(source,destination,capacity);
                }catch(NumberFormatException e){
                    throw new IOException("Negative capacity in line: " + line);
                }

            }
            return graph;
        }
    }

    /**
     * Parse a network flow problem from a string and creates a Graph object
     *
     * @param input  The path to the resource
     * @return  A Graph object representing the network
     * @throws IOException  If there's an error reading the resource
     */
    public static Graph parseFromString(String input) throws IOException{
        try(BufferedReader reader = new BufferedReader(new java.io.StringReader(input))){
            // read number of nodes
            int numNodes = Integer.parseInt(reader.readLine().trim());
            Graph graph = new Graph(numNodes);

            // read edges
            String line;
            while((line = reader.readLine()) != null){
                // skip empty lines
                if(line.trim().isEmpty()){
                    continue;
                }

                String[] parts = line.trim().split("\\s+");
                if(parts.length < 3){
                    throw new IOException("Invalid edge format: " + line);
                }

                try{
                    int source = Integer.parseInt(parts[0]);
                    int destination = Integer.parseInt(parts[1]);
                    int capacity = Integer.parseInt(parts[2]);

                    //add edge to graph
                    graph.addEdge(source, destination, capacity);
                }catch (NumberFormatException e){
                    throw new IOException("Invalid number format in line: " + line, e);
                }
            }
            return graph;
        }
    }
}
