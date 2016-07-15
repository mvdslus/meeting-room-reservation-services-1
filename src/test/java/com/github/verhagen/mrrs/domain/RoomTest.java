package com.github.verhagen.mrrs.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RoomTest {
	@Rule
	public ExpectedException expExcep = ExpectedException.none();


	@Test
	public void createBasicRoom() throws Exception {
		String name = "Berlin";
		String location = "01.02";
		int capacity = 12;
		Room room = new Room(name, location, capacity);
		
		assertEquals(room.getName(), name);
		assertEquals(room.getLocation(), location);
		assertEquals(room.getCapacity(), capacity);
	}

	@Test
	public void createBasicRoomNoName() throws Exception {
		String location = "01.02";
		int capacity = 12;
		Room room = new Room(location, capacity);
		
		assertEquals(room.getName(), location);
		assertEquals(room.getLocation(), location);
		assertEquals(room.getCapacity(), capacity);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createBasicRoomNoLocation() throws Exception {
		String location = null;
		int capacity = 12;
		new Room(location, capacity);
	}

	@Test
	public void createBasicRoomNegativeCapacity() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'capacity' with value '-2' should be a positive value."));

		String location = "1.10";
		int capacity = -2;
		new Room(location, capacity);
	}


	@Test
	public void createRoomWithFacilities() throws Exception {
		String name = "Moscow";
		String location = "02.04";
		int capacity = 10;
		Set<Facility> facilities = new HashSet<>();
		facilities.add(new Facility("whiteboard"));
		facilities.add(new Facility("beamer"));
		Room room = new Room(name, location, capacity, facilities);
		
		assertEquals(room.getName(), name);
		assertEquals(room.getLocation(), location);
		assertEquals(room.getCapacity(), capacity);
		assertEquals(room.getFacilities(), facilities);
	}

}
