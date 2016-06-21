package com.github.verhagen.mrrs.domain;

import static org.junit.Assert.assertEquals;

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

}
