package org.springframework.boot.ratingservice.service;

import java.util.List;

import org.springframework.boot.ratingservice.entity.Rating;
import org.springframework.stereotype.Service;


public interface RatingService {
	
	public Rating create(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingByProdId(String prodId);
}
