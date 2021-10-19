package com.JuanOsorio.MINTIC.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="Room")
public class Room implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String hotel;
	private Integer stars;
	private String description;
	
	//OK
	@ManyToOne
	@JoinColumn(name="categoryId")
	@JsonIgnoreProperties({"rooms","reservations"})
	private Category category;
	
	//OK
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
	@JsonIgnoreProperties({"room","reservations","client"})//add client
	private List<Message> messages = new ArrayList<Message>();
	
	//OK
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
	@JsonIgnoreProperties({"room","reservations"})
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
}
