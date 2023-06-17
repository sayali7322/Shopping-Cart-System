package org.springframework.boot.userservice.repository;

import java.util.List;

import org.springframework.boot.userservice.entrity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
