package com.github.verhagen.mrrs.it.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import com.github.verhagen.mrrs.domain.Facility;
import com.github.verhagen.mrrs.domain.Room;
import com.github.verhagen.mrrs.repository.RoomRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoomSteps {
	private RoomRepository repo = new RoomRepository();
	private Room currentRoom;


	@Given("^a room with name \"(.*?)\", location \"(.*?)\" and capacity (\\d+)$")
	public void a_room_with_name_Berlin_location_and_capacity(String name, String location, int capacity) throws Throwable {
		repo.add(new Room(name, location, capacity));
	}

	@Given("^a room with name \"(.*?)\", location \"(.*?)\" and capacity (\\d+) with facilities: \"(.*?)\"$")
	public void a_room_with_name_location_and_capacity_with_facilities(final String name, final String location,
			final int capacity, final String facilitiesStr) throws Throwable {
		final Set<Facility> facilities = new HashSet<>();
		StringTokenizer tokenizer = new StringTokenizer(facilitiesStr, ",");
		while (tokenizer.hasMoreTokens()) {
			facilities.add(new Facility(tokenizer.nextToken()));
		}

		repo.add(new Room(name, location, capacity, facilities));
	}

	@When("^searching for room with location \"(.*?)\"$")
	public void searching_for_room_with_location(String location) throws Throwable {
		currentRoom = repo.getByLocation(location);
	}

	@Then("^the room with name \"(.*?)\" should be returned$")
	public void the_room_with_name_should_be_returned(String name) throws Throwable {
		assertEquals(name, currentRoom.getName());
	}	

	@Then("^the room should have facility \"(.*?)\"$")
	public void the_room_should_have_facility(String name) throws Throwable {
		assertTrue(currentRoom.getFacilities().contains(new Facility(name)));
	}

	private boolean containsFacility(Set<Facility> facilities, String name) {
		Facility lookupFacility = new Facility(name);
		for (Facility facility : facilities) {
			if (facility.equals(lookupFacility)) {
				return true;
			}
		}
		return false;
	}

}
