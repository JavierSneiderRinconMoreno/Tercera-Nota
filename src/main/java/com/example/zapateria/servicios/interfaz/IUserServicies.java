package com.example.zapateria.servicios.interfaz;

import java.util.List;
import java.util.Optional;

import com.example.zapateria.dto.UserRequest;

import org.springframework.stereotype.Service;

import com.example.zapateria.dto.UserDTO;

@Service
public interface IUserServicies {
	
	List<UserDTO> findAll();
	
	UserDTO findByUsername(String username);
	
	UserDTO findByUseraId(int userId);
	
	void save(UserRequest user);
        
        void update(UserRequest user, int userId);
	
	void saveAll(List<UserRequest> users);
	
	void deleteById(int userId);

}
