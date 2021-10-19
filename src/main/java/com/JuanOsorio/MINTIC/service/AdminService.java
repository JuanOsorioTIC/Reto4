package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Admin;
import com.JuanOsorio.MINTIC.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> getAll(){
		return (List<Admin>)adminRepository.getAll();
	}
	
	public Optional<Admin> getAdmin(int id){
		return adminRepository.getAdmin(id);
	}
	
	public Admin save (Admin admin) {
		if(admin.getId() == null) {
			return adminRepository.save(admin);
		}
		else {
			Optional<Admin> adminExists = adminRepository.getAdmin(admin.getId());
			if(adminExists.isEmpty()) {
				return adminRepository.save(admin);
			}else {
				return admin;
			}
		}
	}
	
	public Admin update(Admin admin) {
		if(admin.getId()!=null) {
			Optional<Admin> optional = adminRepository.getAdmin(admin.getId());
			if(!optional.isEmpty()) {
				if(admin.getName()!=null) {
					optional.get().setName(admin.getName());
				}
				if(admin.getEmail()!=null) {
					optional.get().setEmail(admin.getEmail());
				}
				if(admin.getPassword()!=null) {
					optional.get().setPassword(admin.getPassword());
				}
				return adminRepository.save(optional.get());
			}
			
		}
		return admin;
	}
	
	public boolean delete(int id) {
		Boolean flag = getAdmin(id).map(admin ->{
			adminRepository.delete(admin);
			return true;
		}).orElse(false);
		return flag;
	}
	
}
