package com.JuanOsorio.MINTIC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="Reservation")
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	
	private Date startDate;
	private Date devolutionDate;
	private String status = "created";
	
	
	@ManyToOne
	@JoinColumn(name="roomId")
	@JsonIgnoreProperties({"reservations","client","room"})//room
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	@JsonIgnoreProperties({"reservations","messages"})//removed client, room
	private Client client;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idScore")
	private Score score = null;
}
