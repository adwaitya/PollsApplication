package com.app.polls.repository;
import com.app.polls.domain.*;
import com.app.polls.util.RoleName;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);

}
