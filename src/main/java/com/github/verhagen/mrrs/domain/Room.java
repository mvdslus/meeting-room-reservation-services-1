package com.github.verhagen.mrrs.domain;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class Room {
	private final String name;
	private final String location;
	private final int capacity;
	private final Set<Facility> facilities;


	public Room(final String location, int capacity) {
		this(null, location, capacity);
	}
	public Room(final String name, final String location, int capacity) {
		this(name, location, capacity, new TreeSet<Facility>());
	}
	public Room(final String name, final String location, int capacity, final Set<Facility> facilities) {
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
		this.facilities = facilities;
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


	public Set<Facility> getFacilities() {
		return facilities;
	}


	@Override
	public String toString() {
		final StringBuilder bldr = new StringBuilder();
		if (name != null) {
			bldr.append(name).append(", ");
		}
		bldr.append(location);
		bldr.append(", ").append(capacity);
		if (! facilities.isEmpty()) {
			bldr.append(", [ ").append(toStringFacilities()).append(" ]");
		}

		return bldr.toString(); 
	}

	private String toStringFacilities() {
		StringBuilder bldr = new StringBuilder();
		for (Facility facility : facilities) {
			if (bldr.length() > 0) {
				bldr.append(", ");
			}
			bldr.append(facility.getName());
		}
		return bldr.toString();
	}

}
