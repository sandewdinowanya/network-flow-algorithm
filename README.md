# 📊 Network Flow Algorithm - Coursework Project

This project implements a **maximum flow** algorithm using graph representations of flow networks. The program reads flow networks from input files and computes the **maximum flow** from a given source node to a target (sink) node. This coursework is a part of the Algorithms module.

---

## 🧠 Problem Overview

In many real-world scenarios like traffic systems, data networks, and water pipelines, we deal with *flow networks*. These are modeled as **directed graphs**, where:

- **Nodes** represent switches, junctions, or routers.
- **Edges** carry flow (e.g., vehicles, data packets, liquid).
- Each edge has a **capacity**.
- A **source node** generates flow.
- A **sink node** absorbs flow.

### Flow Rules
- The **flow on an edge** must not exceed its capacity.
- **Flow conservation** applies to all intermediate nodes (except source and sink):  
  Flow In = Flow Out

### Objective
Find the **maximum flow** from source (node `s`) to target (node `t`) in the network.

---

## 🛠️ Features and Tasks

### ✅ Task 1 - Project Setup (Java/C++)
- Initialized a clean, modular project.
- Follows programming standards for readability and maintainability.

### ✅ Task 2 - Data Structure
- Represented the graph using **adjacency lists**.
- Stored capacities and current flows using nested maps or matrices.
- Provided helper methods for basic graph operations (add/remove/search edges).

### ✅ Task 3 - Input Parser
- Supports reading from text files with the following structure:
- Automatically builds the internal graph from the input.

### ✅ Task 4 - Max Flow Algorithm
- Implemented the **Ford-Fulkerson** algorithm using BFS for augmenting path search (Edmonds-Karp variant).
- Tracks incremental changes and displays the path-wise flow updates.
- Outputs:
- Maximum flow value.
- Flow on each edge.
- Step-by-step progress (optional).

### ✅ Task 5 - Report
- Explained algorithm choice and data structure.
- Showed step-by-step execution on a small benchmark.
- Provided performance analysis and time complexity.

---

## 🚀 Getting Started

### Requirements
- Java (JDK 11+) or C++ (C++11+)
- IDE: IntelliJ / Eclipse (Java) or Code::Blocks / Visual Studio (C++)
- CLI or terminal access

### Run Instructions

1. Clone the repository:
 ```bash
 git clone https://github.com/your-username/network-flow-algorithm.git
 cd network-flow-algorithm

2. Compile the project:
Java:
javac src/*.java
java Main input.txt

3. Prepare input file as described and provide the filename as a command-line argument.

Reading input...
Network initialized with 4 nodes.
Applying Ford-Fulkerson Algorithm...
Augmenting path found: 0 -> 1 -> 3 | Bottleneck: 3
Augmenting path found: 0 -> 2 -> 3 | Bottleneck: 4
Augmenting path found: 0 -> 1 -> 2 -> 3 | Bottleneck: 1

Final Flow:
f(0,1) = 4
f(0,2) = 4
f(1,2) = 1
f(1,3) = 3
f(2,3) = 5

Maximum Flow from source to sink: 8

📚 Folder Structure
css
Copy
Edit
network-flow-algorithm/
│
├── src/                     # Source code
│   ├── Main.java / main.cpp
│   ├── Graph.java / Graph.cpp
│   └── MaxFlowSolver.java / MaxFlow.cpp
│
├── input/                   # Example test files
│   └── sample.txt
│
├── report/                  # Task 5 report
│   └── NetworkFlow_Report.pdf
│
├── README.md
└── LICENSE
