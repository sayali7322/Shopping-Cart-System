package org.springframework.boot.ratingservice.repository;

import java.util.List;

import org.springframework.boot.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByProdId(String prodId);
}
