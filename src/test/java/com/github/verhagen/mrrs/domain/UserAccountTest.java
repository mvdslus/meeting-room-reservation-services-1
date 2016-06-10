package com.github.verhagen.mrrs.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserAccountTest {

	@Test
	public void createTintin() throws Exception {
		UserAccount userAccount = new UserAccount("tintin", "Tintin");
		
		assertEquals("tintin", userAccount.getId());
		assertEquals("Tintin", userAccount.getName());
	}

	@Test
	public void createSnowy() throws Exception {
		UserAccount userAccount = new UserAccount(" snowy\n", "\t Snowy");

		assertEquals("snowy", userAccount.getId());
		assertEquals("Snowy", userAccount.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createIdNull() throws Exception {
		new UserAccount(null, "Tintin");
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNameNull() throws Exception {
		new UserAccount("12", " \t ");
	}

}
