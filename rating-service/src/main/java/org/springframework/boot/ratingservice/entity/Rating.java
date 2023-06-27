package org.springframework.boot.ratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int ratingId;
		private int userId;
		private int prodId;
		private int rating;
		private String feedback;
}
