package com.app.api;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.api.controller.UserController;
import com.app.api.infastucture.dto.UserDto;
import com.app.api.infrastructure.repository.database.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class JUnitSpringBootTestingApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public TestEntityManager entityManager;

	@Test
	void contextLoads() {

		UserDto user = new UserDto(10, "Jhooomn", 20);

		entityManager.persist(user);
		entityManager.flush();

		UserDto found = userRepository.findById(user.getId()).get();

		assertThat(found.getUsername()).isEqualTo("Jhooomn");

	}

}
