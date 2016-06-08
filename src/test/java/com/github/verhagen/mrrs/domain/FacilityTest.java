package com.github.verhagen.mrrs.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FacilityTest {


	@Test
	public void createComputerWithLargeScreen() throws Exception {
		Facility facility = new Facility("Computer with large screen");
		
		assertEquals("Computer with large screen", facility.getName());
	}


	@Test
	public void createWhiteborad() throws Exception {
		Facility facility = new Facility("Whiteboard");
		
		assertEquals("Whiteboard", facility.getName());
	}
	
	@Test
	public void compare() throws Exception {
		Facility whiteboard = new Facility("whiteboard");
		Facility beamer = new Facility("beamer");
		assertTrue(whiteboard.compareTo(beamer) > 0);
		assertTrue(beamer.compareTo(whiteboard) < 0);
	}

}
