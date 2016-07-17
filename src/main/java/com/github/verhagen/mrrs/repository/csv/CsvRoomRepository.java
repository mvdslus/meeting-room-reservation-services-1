package com.github.verhagen.mrrs.repository.csv;

import java.io.Reader;

import com.github.verhagen.mrrs.repository.RoomRepository;

public class CsvRoomRepository extends RoomRepository {

	public static RoomRepository importBy(final Reader createReader) {
		final CsvRoomRepository roomRepo = new CsvRoomRepository();
		return roomRepo;
	}

}
