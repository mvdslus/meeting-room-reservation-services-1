package com.github.verhagen.mrrs.repository;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.mrrs.domain.UserAccount;

public class UserAccountRepository {
	private static Logger logger = LoggerFactory.getLogger(UserAccountRepository.class);
	private Map<String, UserAccount> accounts = new HashMap<>();


	public void add(final UserAccount userAccount) {
		accounts.put(createKey(userAccount), userAccount);
	}


	private String createKey(final UserAccount userAccount) {
		return createKey(userAccount.getName());
	}


	private String createKey(final String name) {
		return name.toLowerCase().replace(' ', '-');
	}


	public int size() {
		return accounts.size();
	}


	public UserAccount search(final String name) {
		if (! accounts.containsKey(createKey(name))) {
			logger.info("Not a known user account '" + name + "'");
			return null;
		}

		return accounts.get(createKey(name));
	}

}
