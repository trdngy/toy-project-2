package com.luv2code.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import com.luv2code.entity.FicCharacterIn;
import com.luv2code.entity.MageCharacter;
import com.luv2code.entity.WorldMap;


// TODO Apply Singleton design pattern
// TODO Handle exceptions
// TODO Draw diagrams
// TODO Write instructions
// TODO Write test cases
// TODO Change label of node

public class Main {

	private static HashMap<Integer, String> questions;
	private static HashMap<Integer, String> answers;

	static {
		questions = new HashMap<>();
		answers = new HashMap<>();

		questions.put(1, "What is the capital of Germany?\n\t(a) Berlin\n\t(b) Munich");
		questions.put(2, "What is Java?\n\t(a) A programing language\n\t(b) A city");
		questions.put(3, "Which algorithm are you using to explore the map?\n\t(a) DFS\n\t(b) BFS");
		questions.put(4,
				"What is the underlying data structure adopted for travel algorithm?\n\t(a) Array\n\t(b) Stack");
		questions.put(5, "How can a character gain experience?\n\t(a) Answer questions\n\t(b) Fight against monsters");
		questions.put(6, "How can a map be initialized?\n\t(a) Using static block\n\t(b) Using constructor");
		questions.put(7, "Is this GUI application?\n\t(a) Yes\n\t(b) No");

		answers.put(1, "a");
		answers.put(2, "a");
		answers.put(3, "a");
		answers.put(4, "b");
		answers.put(5, "a");
		answers.put(6, "a");
		answers.put(7, "b");

	}

	public static void main(String[] args) {

		// TODO Require a user to provide username and password to initialize the game

		System.out.println("Welcome to Adventureland");
		System.out.println("\tPress 1 if you are new to this game");
		System.out.println("\tPress 2 if you want to resume your last game");
		Scanner reader = new Scanner(System.in);
		System.out.print("Your choice: ");
		String choice = reader.next();

		WorldMap worldMap = new WorldMap();
		FicCharacterIn myCharacter = new MageCharacter();
		Integer statusCode = -1;

		if (choice.equals("1")) {

		} else if (choice.equals("2")) {
			myCharacter = loadCharacter();
			worldMap = loadWorldMap();
			
			if (myCharacter instanceof MageCharacter) {
				System.out.println("Loading successfully!");
			}
		}

		while (true) {
			// TODO Exit the loop when user press Q or visit all of the node

			statusCode = myCharacter.exploreWorldMap(worldMap, questions, answers);

			// Player wants to save
			if (statusCode == 1) {
				saveGame(myCharacter, worldMap);
				break;
			}

			// Player wants to exit without saving
			if (statusCode == 2) {
				break;
			}

			// Player is defeated
			if (statusCode == 3) {
				System.out.println("\nGame over!");
				break;
			}

			// Player clears the game
			if (statusCode == 0) {
				System.out.print("\nThe map of the world: ");
				myCharacter.printPath();
				break;
			}

		}

		reader.close();

	}

	public static void saveGame(FicCharacterIn myCharacter, WorldMap worldMap) {

		System.out.println("Saving game ...\nSee you later!");
		saveCharacter(myCharacter);
		saveWorldMap(worldMap);
		
		
	}
	
	public static void saveCharacter(FicCharacterIn myCharacter) {

		try {
			FileOutputStream fileOut = new FileOutputStream("savecharacter");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(myCharacter);
			objectOut.close();
			
		} catch (Exception exc) {
			
			exc.printStackTrace();
		}		
	}
	
	public static void saveWorldMap(WorldMap worldMap) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("saveworldmap");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			objectOut.writeObject(worldMap);
			objectOut.close();
			
		} catch (Exception exc) {
			
			exc.printStackTrace();
		}		
	}

	public static FicCharacterIn loadCharacter() {

		System.out.println("\nWelcome back!\nLoading game ...");
		
		try {
			FileInputStream fileIn = new FileInputStream("savecharacter");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			Object obj = objectIn.readObject();
			objectIn.close();
			
			return (FicCharacterIn) obj;
						
		} catch (Exception exc) {
			
			exc.printStackTrace();
		}
		
		return null;

	}
	
	public static WorldMap loadWorldMap() {

		System.out.println("\nWelcome back!\nLoading game ...");
		
		try {
			FileInputStream fileIn = new FileInputStream("saveworldmap");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			Object obj = objectIn.readObject();
			objectIn.close();
			
			return (WorldMap) obj;
						
		} catch (Exception exc) {
			
			exc.printStackTrace();
		}
		
		return null;

	}


}
