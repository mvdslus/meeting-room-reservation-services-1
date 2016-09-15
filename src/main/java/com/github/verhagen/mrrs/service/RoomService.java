package com.github.verhagen.mrrs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.verhagen.mrrs.domain.Room;
import com.github.verhagen.mrrs.repository.RoomRepository;
import com.github.verhagen.mrrs.repository.csv.CsvRoomRepository;


@Path("room")
public class RoomService {
	private final RoomRepository repo;
	

	public RoomService() {
		final String filename = "src/test/resources/room.csv";
		try {
			repo = CsvRoomRepository.importBy(new FileReader(new File(filename)));
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to load rooms from file '" + filename + "'.", e);
		}
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Room> getAll() {
		return repo.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Room getLocation(@PathParam("id") final String id) {
		return repo.getByLocation(id);
	}
	
}
