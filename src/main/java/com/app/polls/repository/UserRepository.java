package com.app.polls.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.polls.domain.User;
import com.app.polls.models.ResultModel;

public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);

//	   public  ResultModel<User> findByUsernameOrEmail(String username, String email);

	    List<User> findByIdIn(List<Long> userIds);

	    Optional<User> findById(Long userId);

	    Optional<User> findByUsername(String username);

	    Boolean existsByUsername(String username);

	    Boolean existsByEmail(String email);

		User findByUsernameOrEmail(String username, String email);

}
