package com.example.zapateria.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.zapateria.dto.UserDTO;
import com.example.zapateria.dto.UserRequest;
import com.example.zapateria.entyties.Users;
import com.example.zapateria.servicios.interfaz.IUserServicies;
import com.example.zapateria.util.helpers.Mhelpers;
import com.example.zapateria.repositorio.UserDAO;
import com.example.zapateria.util.hash.BCrypt;

@Component
public class UserImpl implements IUserServicies {
	
	@Autowired
	private UserDAO userRepository;

	@Override
	public List<UserDTO> findAll() {
		
		List<UserDTO> dto = new ArrayList<>();
		Iterable<Users> users = this.userRepository.findAll();
		
		for(Users user : users) {
			UserDTO usersDTO = Mhelpers.modelMapper().map(users, UserDTO.class);
			dto.add(usersDTO);
		}
		return dto;
	}

	@Override
	public UserDTO findByUsername(String username) {
		
		Optional<Users> users = this.userRepository.findByUsername(username);
		
		if(!users.isPresent()){
			return null;
		}
		
		return Mhelpers.modelMapper().map(users.get(), UserDTO.class);
	}

	@Override
	public UserDTO findByUseraId(int userId) {
		Optional<Users> users = this.userRepository.findById(userId);
		
		if(!users.isPresent()){
			return null;
		}
		
		return Mhelpers.modelMapper().map(users.get(), UserDTO.class);
	}

	@Override
	public void save(UserRequest user) {
		
		Users users = Mhelpers.modelMapper().map( user, Users.class);
                
                users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		this.userRepository.save(users);
		
	}

	@Override
	public void saveAll(List<UserRequest> users) {
		
		List<Users> u = new ArrayList<>();
		
		for(UserRequest user : users ) {
			Users us = Mhelpers.modelMapper().map( user, Users.class);
			u.add(us);
		}
		
		this.userRepository.saveAll(users);
		
	}
        
        @Override
        public void update(UserRequest request, int userId){
            Optional<Users> users = this.userRepository.findById(userId);
            
            Users user = users.get();
            user.setLastname(request.getFirstname());
            
            user.setLastname(request.getLastname());
            
            user.setUsername(request.getUsername());
            
            if(!request.getPassword().isEmpty()){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
            }
            
            this.userRepository.save(user);
        }

	@Override
	public void deleteById(int userId) {
		this.userRepository.deleteById(userId);
		
	}
	
	private UserDTO convertToUsersDTO(final Users users) {
		return Mhelpers.modelMapper().map(users, UserDTO.class);
		
	}

}
