package com.JuanOsorio.MINTIC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JuanOsorio.MINTIC.model.Reservation;
import com.JuanOsorio.MINTIC.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
	
	@Autowired
	private ReservationCrudRepository reservationCrudRepository;

	public List<Reservation> getAll(){
		return (List<Reservation>)reservationCrudRepository.findAll();
	}
	
	
	public Optional<Reservation> getReservation(Integer id){
		return reservationCrudRepository.findById(id);
	}
	
	public Reservation save(Reservation reservation) {
		return reservationCrudRepository.save(reservation);
	}
	
	public void delete(Reservation reservation) {
		reservationCrudRepository.delete(reservation);
	}
	
}
