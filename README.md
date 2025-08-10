# Network Flow Algorithm Implementation

This project implements a solution for finding maximum flow in a network using the Ford-Fulkerson algorithm with DFS path finding.

## Overview

The network flow problem involves finding the maximum amount of flow that can be sent from a source node to a target node in a directed graph with capacity constraints on each edge. This implementation handles integer capacities and follows the conservation of flow principle at each node.

## Project Structure

```
networkflow/
├── src/
│   ├── FlowNetwork.java         # Network graph representation with adjacency matrix
│   ├── NetworkFlowParser.java   # Parses network from input files  
│   ├── MaxFlowAlgorithm.java    # Ford-Fulkerson algorithm implementation
│   └── Main.java               # Entry point of the application
├── input/
│   ├── example1.txt            # Sample network files
│   ├── example2.txt
│   └── benchmark_*.txt
└── output/
    └── results.txt             # Algorithm execution results
```

## Dependencies

- Java Development Kit (JDK) 8 or higher
- No external libraries required

## How to Run

1. Compile the project:
   ```
   javac -d bin src/*.java
   ```

2. Run with input file:
   ```
   java -cp bin Main input/example1.txt
   ```

3. Run with default example:
   ```
   java -cp bin Main
   ```

## Input File Format

The input file should follow this format:
- First line: Number of nodes n (nodes are numbered 0 to n-1)
- Following lines: Edge definitions as "from to capacity"
- Node 0 is the source, and node n-1 is the target

Example:
```
4
0 1 6
0 2 4
1 2 2
1 3 3
2 3 5
```

## Sample Output

```
Network Flow Analysis
====================

Input Network:
Nodes: 4 (Source: 0, Target: 3)
Edges: 5

Ford-Fulkerson Algorithm Execution:
Step 1: Found augmenting path: 0 -> 1 -> 3
        Bottleneck capacity: 3
        Flow increased by: 3
        Current total flow: 3

Step 2: Found augmenting path: 0 -> 2 -> 3
        Bottleneck capacity: 5
        Flow increased by: 5
        Current total flow: 8

Step 3: Found augmenting path: 0 -> 1 -> 2 -> 3
        Bottleneck capacity: 0
        No more augmenting paths found

Final Results:
Maximum Flow: 8

Flow Assignment:
Edge (0,1): 4/6
Edge (0,2): 4/4
Edge (1,2): 1/2
Edge (1,3): 3/3
Edge (2,3): 5/5
```

## Implementation Details

This implementation uses:
- Adjacency matrix representation for the flow network
- Ford-Fulkerson algorithm with Depth-First Search (DFS) to find augmenting paths
- Integer capacities and flows
- Detailed step-by-step execution trace
- Flow conservation validation

## Algorithm Explanation

The Ford-Fulkerson algorithm works by repeatedly finding augmenting paths from source to target and pushing flow along these paths. The implementation:

1. Starts with zero flow on all edges
2. Uses DFS to find augmenting paths from source to target
3. Determines the bottleneck capacity along each path
4. Augments the flow by the bottleneck value
5. Updates residual capacities
6. Continues until no more augmenting paths exist

## Performance Analysis

- Time Complexity: O(E × f) where E is the number of edges and f is the maximum flow value
- Space Complexity: O(V²) for adjacency matrix representation, where V is the number of vertices

## Testing

Run the program with different input files to test various network configurations:

```bash
java -cp bin Main input/example1.txt    # Basic 4-node network
java -cp bin Main input/example2.txt    # More complex network
```

## Output Explanation

The program outputs:
- Network statistics (nodes, edges)
- Step-by-step algorithm execution with augmenting paths
- Final maximum flow value
- Complete flow assignment showing flow/capacity for each edge
- Execution time for performance analysis
