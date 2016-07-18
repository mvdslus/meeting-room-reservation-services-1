package com.github.verhagen.mrrs.domain;

import static org.junit.Assert.assertEquals;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FacilityTest {
	@Rule
	public ExpectedException expExcep = ExpectedException.none();


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
	public void createEmpty() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'name' should not be null."));

		new Facility("  \t ");
	}

}
