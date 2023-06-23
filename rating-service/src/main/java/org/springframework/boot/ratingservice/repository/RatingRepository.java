package org.springframework.boot.ratingservice.repository;

import java.util.List;

import org.springframework.boot.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RatingRepository extends MongoRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByProdId(String prodId);
}
