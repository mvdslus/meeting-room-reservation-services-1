package com.github.verhagen.mrrs;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyResourceTest {

	@Test
	public void getIt() throws Exception {
		assertEquals("Got it!", new MyResource().getIt());
	}

}
