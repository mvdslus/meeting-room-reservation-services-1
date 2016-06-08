package com.github.verhagen.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

public class Room {
	private final String name;
	private final String location;
	private final int capacity;


	public Room(final String name, final String location, int capacity) {
		final String locationCln = StringUtils.trimToNull(location);
		if (locationCln == null) {
			throw new IllegalArgumentException("Argument 'location' should not be null.");
		}
		if (capacity <= 0) {
			throw new IllegalArgumentException("Argument 'capacity' with value '"
					+ capacity + "' should be a positive value.");
		}
		
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}


	public Room(String location, int capacity) {
		this(null, location, capacity);
	}


	public String getName() {
		if (name == null) {
			return location;
		}
		return name;
	}


	public String getLocation() {
		return location;
	}


	public int getCapacity() {
		return capacity;
	}

}
