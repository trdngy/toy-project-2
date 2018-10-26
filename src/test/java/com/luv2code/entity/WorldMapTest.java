package com.luv2code.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WorldMapTest {
	private WorldMap worldMap;

	@Before
	public void init() {
		worldMap = new WorldMap();
	}

	@Test
	public void getNodes() {
		ArrayList<Node> actualNodes = worldMap.getNodes();

		assertEquals("GPG", actualNodes.get(0).getLabel());
		assertEquals("TAE", actualNodes.get(1).getLabel());
		assertEquals("SZO", actualNodes.get(2).getLabel());
		assertEquals("MH", actualNodes.get(3).getLabel());
		assertEquals("CR", actualNodes.get(4).getLabel());
		assertEquals("LA", actualNodes.get(5).getLabel());
		assertEquals("HGB", actualNodes.get(6).getLabel());

	}

	@Test
	public void getAdjacencyMatrix() {
		Integer[][] actual = worldMap.getAdjacencyMatrix();
		Integer[][] expect = new Integer[][] { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};

		assertArrayEquals(expect[0], actual[0]);
		assertArrayEquals(expect[1], actual[1]);
		assertArrayEquals(expect[2], actual[2]);
		assertArrayEquals(expect[3], actual[3]);
		assertArrayEquals(expect[4], actual[4]);
		assertArrayEquals(expect[5], actual[5]);
		assertArrayEquals(expect[6], actual[6]);

	}

	@Test
	public void getNode() {
		Node node = worldMap.getNode(0);
		assertEquals("GPG", node.getLabel());
	}

	@Test
	public void getIndex() {
		Integer actual = worldMap.getIndex("GPG");
		assertEquals(0, actual.intValue());

	}

	@Test
	public void isClear() {
		assertEquals(false, worldMap.isClear());
	}

}
