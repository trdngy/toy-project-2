package com.luv2code.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class WorldMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Represent the relationship of composition between WorldMap and Node
	private final ArrayList<Node> nodes;
	private Integer[][] adjacencyMatrix;

	public WorldMap() {

		System.out.println("Initializing the world ...");

		nodes = new ArrayList<>();
		Node node40 = new Node("GPG"); // GPG: Great Pyramid of Giza
		Node node10 = new Node("TAE"); // TAE: Temple of Artemis at Ephesus
		Node node20 = new Node("SZO"); // SZO: Statue of Zeus at Olympia
		Node node30 = new Node("MH"); // MH: Mausoleum at Halicarnassus
		Node node60 = new Node("CR"); // CR: Colossus of Rhodes
		Node node50 = new Node("LA"); // LA: Lighthouse of Alexandria
		Node node70 = new Node("HGB"); // HGB: Hanging Gardens of Babylon

		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);

		adjacencyMatrix = new Integer[][] { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};

	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public Integer[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(Integer[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public Node getNode(Integer index) {
		return this.nodes.get(index);
	}

	public Integer getIndex(String label) {

		for (Node node : nodes) {
			if (node.getLabel().equals(label)) {
				return nodes.indexOf(node);
			}
		}

		return null;
	}

	public Boolean isClear() {
		for (Node n : nodes) {
			if (!n.isVisited()) {
				return false;
			}
		}

		return true;
	}

}
