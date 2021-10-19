package com.JuanOsorio.MINTIC.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.JuanOsorio.MINTIC.model.Room;
import com.JuanOsorio.MINTIC.service.RoomService;

@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/all")
	public List<Room> getRoom(){
		return roomService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Room> getRoom(@PathVariable("id") int id){
		return roomService.getRoom(id);		
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Room save(@RequestBody Room room) {
		return roomService.save(room);		
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Room update(@RequestBody Room room) {
		return roomService.update(room);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteRoom(@PathVariable("id") int id) {
		return roomService.delete(id);
	}
	
	
}
