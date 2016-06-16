package com.github.verhagen.mrrs.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.mrrs.domain.Room;

public class RoomRepository {
	private static Logger logger = LoggerFactory.getLogger(RoomRepository.class);
	private Map<String, Room> rooms = new HashMap<>();


	public void add(final Room room) {
		if (room == null) {
			throw new IllegalArgumentException("Argument 'room' should not be null.");
		}
		if (rooms.containsKey(room.getLocation())) {
			throw new IllegalArgumentException("There is already a room registered with the location '"
					+ room.getLocation() + "'. Registered room '" + rooms.get(room.getLocation()) + "'");
		}

		rooms.put(room.getLocation(), room);
	}

	public int size() {
		return rooms.size();
	}

	public Room getByLocation(final String location) {
		String locationCln = StringUtils.trimToNull(location);
		if (locationCln == null) {
			return null;
		}

		if (! rooms.containsKey(locationCln)) {
			logger.error("No room known with location '" + locationCln + "'.");
		}

		return rooms.get(locationCln);
	}

}
