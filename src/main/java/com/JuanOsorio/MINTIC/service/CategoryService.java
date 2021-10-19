package com.JuanOsorio.MINTIC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanOsorio.MINTIC.model.Category;
import com.JuanOsorio.MINTIC.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		return (List<Category>)categoryRepository.getAll();
	}
	
	public Optional<Category> getCategory(int id){
		return categoryRepository.getCategory(id);
	}
	
	public Category save (Category category) {
		if(category.getId() == null) {
			return categoryRepository.save(category);
		}
		else {
			Optional<Category> categoryExists = categoryRepository.getCategory(category.getId());
			if(categoryExists.isEmpty()) {
				return categoryRepository.save(category);
			}else {
				return category;
			}
		}
	}
	
	public Category update(Category category) {
		if(category.getId()!=null) {
			Optional<Category> optional = categoryRepository.getCategory(category.getId());
			if(!optional.isEmpty()) {
				if(category.getName()!=null) {
					optional.get().setName(category.getName());
				}
				if(category.getDescription()!=null) {
					optional.get().setDescription(category.getDescription());
				}
				return categoryRepository.save(optional.get());
			}
			
		}
		return category;
	}
	
	public boolean delete(int id) {
		Boolean flag = getCategory(id).map(category ->{
			categoryRepository.delete(category);
			return true;
		}).orElse(false);
		return flag;
	}
	
	
}
