package com.github.verhagen.mrrs.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.verhagen.mrrs.domain.Facility;
import com.github.verhagen.mrrs.domain.Room;

public class RoomRepositoryTest {
	@Rule
	public ExpectedException expExcep = ExpectedException.none();


	@Test
	public void getByLocation() throws Exception {
		RoomRepository repo = new RoomRepository();
		repo.add(new Room("01.12", 8));
		repo.add(new Room("01.14", 8));
		repo.add(new Room("01.16", 10));

		assertEquals(repo.size(), 3);

		Room room = repo.getByLocation("01.14");
		assertNotNull(room);
		assertEquals(room.getCapacity(), 8);
	}

	@Test
	public void addNull() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'room' should not be null."));

		RoomRepository repo = new RoomRepository();
		repo.add(null);
	}

	@Test
	public void addWithSameLocation() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("There is already a room registered with the location '01.12'."
				+ " Registered room details 'Copenhagen, 01.12, 8, [ white board ]'"));

		Set<Facility> facilities = new HashSet<>();
		facilities.add(new Facility("white board"));
		RoomRepository repo = new RoomRepository();
		Room room = new Room("Copenhagen", "01.12", 8, facilities);
		repo.add(room);
		repo.add(room);
	}

	@Test	
	public void getByLocationNull() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'location' should not be null."));

		RoomRepository repo = new RoomRepository();
		repo.getByLocation("\t");
	}

	@Test	
	public void getByLocationNotKnown() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'location' with value '01.10' is not a known room."));

		RoomRepository repo = new RoomRepository();
		repo.getByLocation("01.10");
	}

}
