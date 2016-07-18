package com.github.verhagen.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

public class Facility {
	private final String name;


	public Facility(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			throw new IllegalArgumentException("Argument 'name' should not be null.");
		}

		this.name = nameCln;
	}


	public String getName() {
		return name;
	}

}
