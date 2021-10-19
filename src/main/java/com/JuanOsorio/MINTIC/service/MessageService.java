package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Message;
import com.JuanOsorio.MINTIC.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> getAll(){
		return (List<Message>)messageRepository.getAll();
	}
	
	public Optional<Message> getMessage(int id){
		return messageRepository.getMessage(id);
	}
	
	public Message save (Message message) {
		if(message.getIdMessage() == null) {
			return messageRepository.save(message);
		}
		else {
			Optional<Message> messageExists = messageRepository.getMessage(message.getIdMessage());
			if(messageExists.isEmpty()) {
				return messageRepository.save(message);
			}else {
				return message;
			}
		}
	}
	
	public Message update(Message message) {
		if(message.getIdMessage()!=null) {
			Optional<Message> optional = messageRepository.getMessage(message.getIdMessage());
			if(!optional.isEmpty()) {
				if(message.getMessageText()!=null) {
					optional.get().setMessageText(message.getMessageText());
				}
				return messageRepository.save(optional.get());
			}
			
		}
		return message;
	}
	
	public boolean delete(int id) {
		Boolean flag = getMessage(id).map(message ->{
			messageRepository.delete(message);
			return true;
		}).orElse(false);
		return flag;
	}
	
}
