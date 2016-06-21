package com.github.verhagen.mrrs.it.cucumber;

import com.github.verhagen.mrrs.domain.Room;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoomSteps {
	private Room room;


	@Given("^a room with name \"(.*?)\", location \"(.*?)\" and capacity (\\d+)$")
	public void a_room_with_name_Berlin_location_and_capacity(String name, String location, int capacity) throws Throwable {
		room = new Room(name, location, capacity);
	}

	@Given("^which has facility \"(.*?)\"$")
	public void which_has_facility(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^searching for room with location \"(.*?)\"$")
	public void searching_for_room_with_location(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the room with name \"(.*?)\" should be returned$")
	public void the_room_with_name_should_be_returned(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}	

}
