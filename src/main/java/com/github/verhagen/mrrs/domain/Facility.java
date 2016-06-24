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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facility other = (Facility) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
