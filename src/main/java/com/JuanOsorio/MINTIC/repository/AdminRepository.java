package com.JuanOsorio.MINTIC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JuanOsorio.MINTIC.model.Admin;
import com.JuanOsorio.MINTIC.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {

	@Autowired
	private AdminCrudRepository adminCrudRepository;

	public List<Admin> getAll(){
		return (List<Admin>)adminCrudRepository.findAll();
	}
	
	
	public Optional<Admin> getAdmin(Integer id){
		return adminCrudRepository.findById(id);
	}
	
	public Admin save(Admin admin) {
		return adminCrudRepository.save(admin);
	}
	public void delete(Admin admin) {
		adminCrudRepository.delete(admin);
		
	}
	
}
