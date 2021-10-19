 package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Score;
import com.JuanOsorio.MINTIC.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	public List<Score> getAll(){
		return (List<Score>)scoreRepository.getAll();
	}
	
	public Optional<Score> getScore(int id){
		return scoreRepository.getScore(id);
	}
	
	public Score save (Score score) {
		if(score.getIdScore() == null) {
			return scoreRepository.save(score);
		}
		else {
			Optional<Score> scoreExists = scoreRepository.getScore(score.getIdScore());
			if(scoreExists.isEmpty()) {
				return scoreRepository.save(score);
			}else {
				return score;
			}
		}
	}
	
	public Score update(Score score) {
		if(score.getIdScore()!=null) {
			Optional<Score> optional = scoreRepository.getScore(score.getIdScore());
			if(!optional.isEmpty()) {
				if(score.getMessageText()!=null) {
					optional.get().setMessageText(score.getMessageText());
				}
				if(score.getStars()!=null) {
					optional.get().setStars(score.getStars());
				}
				return scoreRepository.save(optional.get());
			}
			
		}
		return score;
	}
	
	public boolean delete(int id) {
		Boolean flag = getScore(id).map(score ->{
			scoreRepository.delete(score);
			return true;
		}).orElse(false);
		return flag;
	}
	
}
