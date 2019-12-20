package com.app.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.infastucture.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {

	public UserDto findByUsername(String username);
}
