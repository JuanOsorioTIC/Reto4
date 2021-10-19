package com.JuanOsorio.MINTIC.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="Message")
public class Message  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	private String messageText;
	
	//OK
	@ManyToOne
	@JoinColumn(name="roomId")
	@JsonIgnoreProperties({"messages","reservations"})//removed client
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	@JsonIgnoreProperties({"messages","reservations"})//removed client
	private Client client;

}
