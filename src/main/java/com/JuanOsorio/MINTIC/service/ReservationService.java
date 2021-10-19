package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Reservation;
import com.JuanOsorio.MINTIC.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getAll(){
		return (List<Reservation>)reservationRepository.getAll();
	}
	
	public Optional<Reservation> getReservation(int id){
		return reservationRepository.getReservation(id);
	}
	
	public Reservation save (Reservation reservation) {
		if(reservation.getIdReservation() == null) {
			return reservationRepository.save(reservation);
		}
		else {
			Optional<Reservation> reservationExists = reservationRepository.getReservation(reservation.getIdReservation());
			if(reservationExists.isEmpty()) {
				return reservationRepository.save(reservation);
			}else {
				return reservation;
			}
		}
	}
	
	public Reservation update(Reservation reservation) {
		if(reservation.getIdReservation()!=null) {
			Optional<Reservation> optional = reservationRepository.getReservation(reservation.getIdReservation());
			if(!optional.isEmpty()) {
				if(reservation.getStartDate()!=null) {
					optional.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate()!=null) {
					optional.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				return reservationRepository.save(optional.get());
			}
			
		}
		return reservation;
	}
	
	public boolean delete(int id) {
		Boolean flag = getReservation(id).map(reservation ->{
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return flag;
	}
	
}
