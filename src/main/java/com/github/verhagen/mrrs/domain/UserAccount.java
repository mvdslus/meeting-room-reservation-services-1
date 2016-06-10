package com.github.verhagen.mrrs.domain;

import org.apache.commons.lang3.StringUtils;

public class UserAccount {
	private final String id;
	private final String name;


	public UserAccount(final String id, final String name) {
		final String idCln = StringUtils.trimToNull(id);
		final String nameCln = StringUtils.trimToNull(name);
		if (idCln == null) {
			throw new IllegalArgumentException("Argument 'id' should not be null.");
		}
		if (nameCln == null) {
			throw new IllegalArgumentException("Argument 'name' should not be null.");
		}

		this.id = idCln;
		this.name = nameCln;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

}
