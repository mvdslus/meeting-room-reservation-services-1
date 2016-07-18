package com.github.verhagen.mrrs.repository.csv;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import com.github.verhagen.mrrs.repository.RoomRepository;

public class CsvRoomRepositoryTest {

	@Test
	public void importByReader() throws Exception {
		RoomRepository roomRepo = CsvRoomRepository.importBy(createReader());

		assertEquals("A02", roomRepo.getByLocation("A02").getName());
		assertEquals("A02, 6", roomRepo.getByLocation("A02").toString());

		assertEquals("Amsterdam", roomRepo.getByLocation("B22").getName());
		assertEquals("Amsterdam, B22, 10, [ white board ]", roomRepo.getByLocation("B22").toString());

		assertEquals("Berlin", roomRepo.getByLocation("B24").getName());
		assertEquals("Berlin, B24, 16, [ large screen, white board ]", roomRepo.getByLocation("B24").toString());
	}


	private Reader createReader() {
		final StringBuilder bldr = new StringBuilder();
		bldr.append("name; location; capacity; facilities\n");
		bldr.append("; A02; 6;\n");
		bldr.append("Amsterdam; B22; 10; white board\n");
		bldr.append("Berlin; B24; 16; large screen, white board\n");
		return new StringReader(bldr.toString());
	}

}
