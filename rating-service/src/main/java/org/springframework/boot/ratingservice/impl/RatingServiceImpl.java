package org.springframework.boot.ratingservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ratingservice.entity.Rating;
import org.springframework.boot.ratingservice.repository.RatingRepository;
import org.springframework.boot.ratingservice.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository repository;

	@Override
	public Rating create(Rating rating) {
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByProdId(String prodId) {
		return repository.findByProdId(prodId);
	}

}
