package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Client;
import com.JuanOsorio.MINTIC.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return (List<Client>)clientRepository.getAll();
	}
	
	public Optional<Client> getClient(int id){
		return clientRepository.getClient(id);
	}
	
	public Client save (Client client) {
		if(client.getIdClient() == null) {
			return clientRepository.save(client);
		}
		else {
			Optional<Client> clientExists = clientRepository.getClient(client.getIdClient());
			if(clientExists.isEmpty()) {
				return clientRepository.save(client);
			}else {
				return client;
			}
		}
	}
	
	public Client update(Client client) {
		if(client.getIdClient()!=null) {
			Optional<Client> optional = clientRepository.getClient(client.getIdClient());
			if(!optional.isEmpty()) {
				if(client.getName()!=null) {
					optional.get().setName(client.getName());
				}
				if(client.getEmail()!=null) {
					optional.get().setEmail(client.getEmail());
				}
				if(client.getPassword()!=null) {
					optional.get().setPassword(client.getPassword());
				}
				if(client.getAge()!=null) {
					optional.get().setAge(client.getAge());
				}
				return clientRepository.save(optional.get());
			}
			
		}
		return client;
	}
	
	public boolean delete(int id) {
		Boolean flag = getClient(id).map(admin ->{
			clientRepository.delete(admin);
			return true;
		}).orElse(false);
		return flag;
	}
	
	
}
