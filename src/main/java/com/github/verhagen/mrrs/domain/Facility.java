package com.github.verhagen.mrrs.domain;

public class Facility implements Comparable<Facility>{
	private final String name;


	public Facility(final String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	@Override
	public int compareTo(final Facility other) {
		return this.getName().compareTo(other.getName());
	}

}
