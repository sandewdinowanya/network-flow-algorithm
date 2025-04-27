package networkflow;

import networkflow.java.algorithm.MaxFlowAlgorithm;
import networkflow.java.model.Graph;
import networkflow.java.util.NetworkParser;

import java.io.IOException;
import java.util.List;


public class Main {

    /**
     * Main method to run the network flow algorithm
     *
     * @param args Commands line arguments
     */
    public static void main(String[] args) {

        // Get input file from command line arguments or use default
        String inputFile = args.length > 0 ? args[0] : "src/networkflow/resources/network.txt";

        try{
            // If file path doesn't work, try using resource loading
            System.out.println("Reading network from file: " + inputFile);
            Graph graph = NetworkParser.parseFromFile(inputFile);
            System.out.println("Network loaded with " + graph.getNumNodes() + " nodes.");
            System.out.println(graph);

            // run ford-fulkerson algorithm
            System.out.println("Running Ford-Fulkerson algorithm");
            MaxFlowAlgorithm algorithm = new MaxFlowAlgorithm(graph);

            // source is node 0, sink is the last node
            int source = 0;
            int sink = graph.getNumNodes()-1;

            // find maximum flow
            int maxFlow = algorithm.findMaxFlow(source, sink);

            // print results
            System.out.println("\n******RESULTS******");
            System.out.println("Maximum flow node " + source + " to node " + sink + ": " + maxFlow);

            // print results
            System.out.println("\n******ALGORITHM STEPS******");
            List<String> steps = algorithm.getSteps();
            for(String step : steps){
                System.out.println(step);
            }

            // print final flow on each edge
            System.out.println("\n********FINAL FLOW ASSIGNMENT*********");
            printFinalFlow(graph);

        } catch(IOException e){
            System.err.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();

        } catch(Exception e){
            System.out.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void printFinalFlow(Graph graph){
        for(int i = 0; i<graph.getNumNodes();i++){
            for(var edge : graph.getEdgesFrom(i)){
                // only print edges with positive capacity
                if(edge.getCapacity() > 0){
                    System.out.println("f(" + edge.getSource() + "," + edge.getDestination() + ") = " + edge.getFlow() + " / " + edge.getCapacity());
                }
            }
        }
    }
}