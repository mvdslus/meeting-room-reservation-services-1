package com.github.verhagen.mrrs.repository.csv;

import java.io.Reader;
import java.util.List;

import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;

import com.github.verhagen.mrrs.repository.RoomRepository;

public class CsvRoomRepository extends RoomRepository {

	public static RoomRepository importBy(final Reader reader) {
		final CsvRoomRepository roomRepo = new CsvRoomRepository();
		final CsvClient<CsvRoom> csvReader = new CsvClientImpl<>(reader, CsvRoom.class);
		final List<CsvRoom> beans = csvReader.readBeans();
		
		for (CsvRoom bean : beans) {
			roomRepo.add(bean.createRoom());
		}
		
		return roomRepo;
	}

}
