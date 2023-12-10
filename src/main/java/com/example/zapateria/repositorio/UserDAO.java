 package com.example.zapateria.repositorio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDAO<Users> extends CrudRepository<Users,Integer> {
	
	//la anotacion solo es para que solo se pueda consultar 
	@Transactional(readOnly = true)
	Optional<Users> findByUsername(String username);
	
}
