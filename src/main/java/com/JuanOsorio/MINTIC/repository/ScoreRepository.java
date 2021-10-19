package com.JuanOsorio.MINTIC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JuanOsorio.MINTIC.model.Score;
import com.JuanOsorio.MINTIC.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
	
	@Autowired
	private ScoreCrudRepository scoreCrudRepository;

	public List<Score> getAll(){
		return (List<Score>)scoreCrudRepository.findAll();
	}
	
	
	public Optional<Score> getScore(Integer id){
		return scoreCrudRepository.findById(id);
	}
	
	public Score save(Score score) {
		return scoreCrudRepository.save(score);
	}
	
	public void delete(Score score) {
		scoreCrudRepository.delete(score);
	}
	
}
