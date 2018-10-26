package com.luv2code.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class MageCharacterTest {

	private WorldMap worldMap;
	private MageCharacter mageCharacter;
	private HashMap<Integer, String> questions;
	private HashMap<Integer, String> answers;

	@Before
	public void init() {
		worldMap = new WorldMap();
		mageCharacter = new MageCharacter();

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

	@Test
	public void exploreMap() {

		// Have not implemented yet
	}

	@Test
	public void fightMonster() {
		assertEquals(true, answers.get(1).equals("a"));
		assertEquals(true, answers.get(2).equals("a"));
		assertEquals(true, answers.get(3).equals("a"));
		assertEquals(true, answers.get(4).equals("b"));
		assertEquals(true, answers.get(5).equals("a"));
		assertEquals(true, answers.get(6).equals("a"));
		assertEquals(true, answers.get(7).equals("b"));
	}

	@Test
	public void findClue() {
		ArrayList<Node> neighbours = new ArrayList<>();

		neighbours = mageCharacter.findClue(worldMap, new Node("GPG"));
		assertEquals(Arrays.asList("TAE", "SZO"), Arrays.asList(neighbours.get(0).getLabel(), neighbours.get(1).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("TAE"));
		assertEquals(Arrays.asList("MH"), Arrays.asList(neighbours.get(0).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("SZO"));
		assertEquals(Arrays.asList("TAE", "MH", "CR", "LA"), Arrays.asList(neighbours.get(0).getLabel(),
				neighbours.get(1).getLabel(), neighbours.get(2).getLabel(), neighbours.get(3).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("MH"));
		assertEquals(Arrays.asList("CR"), Arrays.asList(neighbours.get(0).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("CR"));
		assertEquals(Arrays.asList("HGB"), Arrays.asList(neighbours.get(0).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("LA"));
		assertEquals(Arrays.asList("HGB"), Arrays.asList(neighbours.get(0).getLabel()));

		neighbours = mageCharacter.findClue(worldMap, new Node("HGB"));
		assertEquals(Arrays.asList(), Arrays.asList());

	}

	@Test
	public void printPath() {

		// Have not implemented yet

	}

}
