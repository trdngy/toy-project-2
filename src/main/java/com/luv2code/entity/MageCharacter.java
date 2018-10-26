package com.luv2code.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MageCharacter implements FicCharacterIn, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hP;
	private Integer questionID;
	private ArrayList<String> path;
	private Stack<Node> stack;

	public MageCharacter() {
		System.out.println("Initializing the character ...");

		this.questionID = 0;
		this.hP = 20;
		this.path = new ArrayList<>();
		this.stack = new Stack<>();
	}

	@Override
	public Integer exploreWorldMap(WorldMap worldMap, HashMap<Integer, String> questions,
			HashMap<Integer, String> answers) {

		System.out.println("\nYour character is exploring the world ...\n");

		Node startNode;
		Scanner reader = new Scanner(System.in);
		String choice;

		if (questionID == 0) {
			startNode = worldMap.getNode(0);
			this.stack.add(startNode);
			startNode.setVisited(true);
		}

		while (!stack.isEmpty()) {

			System.out.println("Menu bar: Save and Exit (se)\tExit without saving (e)\t Countinue (c)");
			System.out.print("Your choice: ");
			choice = reader.next();

			if (choice.equals("se")) {
				reader.close();
				return 1; // save and exit

			} else if (choice.equals("e")) {
				reader.close();
				return 2; // exit without saving

			} else if (choice.equals("c")) {

				Node currentNode = this.stack.pop();
				System.out.println("====== Node: " + currentNode.getLabel());

				// TODO Save the order of the path
				path.add(currentNode.getLabel());

				// fight against monsters
				this.questionID += 1;
				if (fightMonster(questionID, questions, answers)) {
					System.out.println("You striked the game!");

					// Look for the connected nodes
					ArrayList<Node> neighbours = findClue(worldMap, currentNode);

					// Add connected nodes into stack and assign the label "visited" to true
					for (int i = 0; i < neighbours.size(); i++) {
						Node node = neighbours.get(i);
						if (node != null && !node.isVisited()) {
							this.stack.add(node);
							node.setVisited(true);
						}
					}
				} else {
					System.out.println("You are defeated ...");

					this.questionID -= 1;
					this.hP -= 10;

					if (this.hP <= 0) {
						reader.close();
						return 3; // game over
					}

					this.stack.add(currentNode);
				}

			}
		}

		reader.close();
		return 0; // finish game
	}

	@Override
	public Boolean fightMonster(Integer questionID, HashMap<Integer, String> questions,
			HashMap<Integer, String> answers) {

		System.out.println("Mage is fighting against monster ...");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);

		System.out.println(questions.get(questionID));
		System.out.print("Input your answer: ");
		String answer = reader.next();

		if (answers.get(questionID).equals(answer))
			return true;

		return false;
	}

	@Override
	public ArrayList<Node> findClue(WorldMap worldMap, Node currentNode) {

		ArrayList<Node> nodes = worldMap.getNodes();
		ArrayList<Node> neighbours = new ArrayList<>();
		Integer[][] adjacencyMatrix = worldMap.getAdjacencyMatrix();
		Integer index = worldMap.getIndex(currentNode.getLabel()); // nodes.indexOf(currentNode)

		for (int i = 0; i < adjacencyMatrix[index].length; i++) {
			if (adjacencyMatrix[index][i] == 1) {
				neighbours.add(nodes.get(i));
			}
		}

		return neighbours;
	}

	@Override
	public void printPath() {
		for (String i : path) {
			System.out.print(i + " ");
		}
	}

}
