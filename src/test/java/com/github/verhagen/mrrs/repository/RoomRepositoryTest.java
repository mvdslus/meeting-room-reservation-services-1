package com.github.verhagen.mrrs.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.verhagen.mrrs.domain.Room;

public class RoomRepositoryTest {

	@Test
	public void testName() throws Exception {
		RoomRepository repo = new RoomRepository();
		repo.add(new Room("01.12", 8));
		repo.add(new Room("01.14", 8));
		repo.add(new Room("01.16", 10));

		assertEquals(repo.size(), 3);

		Room room = repo.getByLocation("01.14");
		assertNotNull(room);
		assertEquals(room.getCapacity(), 12);
	}

}
