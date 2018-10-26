package com.luv2code.entity;

import java.util.ArrayList;
import java.util.HashMap;

public interface FicCharacterIn {
	
	public Integer exploreWorldMap(WorldMap worldMap, HashMap<Integer, String> questions, 
			HashMap<Integer, String> answers);
	
	public ArrayList<Node> findClue(WorldMap worldMap, Node currentNode);

	public Boolean fightMonster(Integer qeustionID, HashMap<Integer, String> questions, 
			HashMap<Integer, String> answers);
	
	public void printPath();
	
}
