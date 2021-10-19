package com.JuanOsorio.MINTIC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JuanOsorio.MINTIC.model.Room;
import com.JuanOsorio.MINTIC.repository.crud.RoomCrudRepository;

@Repository
public class RoomRepository {
	
	@Autowired
	private RoomCrudRepository roomCrudRepository;

	public List<Room> getAll(){
		return (List<Room>)roomCrudRepository.findAll();
	}
	
	
	public Optional<Room> getRoom(Integer id){
		return roomCrudRepository.findById(id);
	}
	
	public Room save(Room room) {
		return roomCrudRepository.save(room);
	}
	
	public void delete(Room room) {
		roomCrudRepository.delete(room);
	}
	
}
