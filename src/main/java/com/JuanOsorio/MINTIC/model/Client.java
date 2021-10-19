package com.JuanOsorio.MINTIC.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="Client")
public class Client  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	private String email;
	private String password;
	private String name;
	private Integer age;
	
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
	@JsonIgnoreProperties({"client"})//removed reservations
	private List<Message> messages = new ArrayList<Message>();
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
	@JsonIgnoreProperties({"client"})//removed reservations
	private List<Reservation> reservations = new ArrayList<Reservation>();
	

}
