package com.luv2code.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private boolean visited;
	private List<Node> neighbours;

	public Node() {
	}

	public Node(String label) {
		this.label = label;
		this.neighbours = new ArrayList<>();

	}

	public void addneighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
