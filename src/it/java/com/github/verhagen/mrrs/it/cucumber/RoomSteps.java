package com.github.verhagen.mrrs.it.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoomSteps {

	@Given("^a room with name '(.*?)', location '(.*?)' and capacity (\\d+)$")
	public void a_room_with_name_location_and_capacity(final String name, final String location, final int capacity) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	@Given("^a room with name '(.*?)', location '(.*?)' and capacity (\\d+) which has facilities '(.*?)'$")
	public void a_room_with_name_Berlin_location_and_capacity_which_has_facilities_whiteboard(final String name, final String location,
			final int capacity, final String facilities) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^which has facility '(.*?)'$")
	public void which_has_facility(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^searching for room with location '(.*?)'$")
	public void searching_for_room_with_location(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the room with name '(.*?)' should be returned$")
	public void the_room_with_name_should_be_returned(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^no facilities$")
	public void no_facilities() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^has facilities '(.*?)'$")
	public void has_facilities_whiteboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
