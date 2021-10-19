 package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Room;
import com.JuanOsorio.MINTIC.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> getAll(){
		return (List<Room>)roomRepository.getAll();
	}
	
	public Optional<Room> getRoom(int id){
		return roomRepository.getRoom(id);
	}
	
	public Room save (Room room) {
		if(room.getId() == null) {
			return roomRepository.save(room);
		}
		else {
			Optional<Room> roomExists = roomRepository.getRoom(room.getId());
			if(roomExists.isEmpty()) {
				return roomRepository.save(room);
			}else {
				return room;
			}
		}
	}
	
	public Room update(Room room) {
		if(room.getId()!=null) {
			Optional<Room> optional = roomRepository.getRoom(room.getId());
			if(!optional.isEmpty()) {
				if(room.getName()!=null) {
					optional.get().setName(room.getName());
				}
				if(room.getHotel()!=null) {
					optional.get().setHotel(room.getHotel());
				}
				if(room.getStars()!=null) {
					optional.get().setStars(room.getStars());
				}
				if(room.getDescription()!=null) {
					optional.get().setDescription(room.getDescription());
				}
				return roomRepository.save(optional.get());
			}
			
		}
		return room;
	}
	
	public boolean delete(int id) {
		Boolean flag = getRoom(id).map(room ->{
			roomRepository.delete(room);
			return true;
		}).orElse(false);
		return flag;
	}
	
}
