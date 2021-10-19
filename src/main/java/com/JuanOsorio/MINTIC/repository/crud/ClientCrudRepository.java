package com.JuanOsorio.MINTIC.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JuanOsorio.MINTIC.model.Client;

public interface ClientCrudRepository extends JpaRepository<Client, Integer> {

	Optional<Client> findByEmail(Integer email);
	Optional<Client> findByName(String name);
	
}
