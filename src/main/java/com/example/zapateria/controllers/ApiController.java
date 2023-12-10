package com.example.zapateria.controllers;

import com.example.zapateria.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zapateria.servicios.interfaz.IUserServicies;
import com.example.zapateria.util.exceptions.ApiUnprocessableEntity;
import com.example.zapateria.validator.UserValidator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController 
@RequestMapping("/users")
public class ApiController {
	
	@Autowired
	private  IUserServicies userService;
        @Autowired
	private  UserValidator userValidator;
	

	@RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.userService.findAll());
	}
        
        @GetMapping(value = "/by/{username}" ,  produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
            return ResponseEntity.ok(this.userService.findByUsername(username));
        }
        
        @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnprocessableEntity{
            
            this.userValidator.validator(request);
            this.userService.save(request);
            
            return ResponseEntity.ok(Boolean.TRUE);
        }
        
        
        @DeleteMapping(value = "/{userId}/delte")
        public ResponseEntity<Object> deleteUser(@PathVariable int userId){
            
            this.userService.deleteById(userId);
            return ResponseEntity.ok(Boolean.TRUE);
        }
        
        
        @PutMapping(value = "/{userId}/update")
        public ResponseEntity<Object> updateUser(@RequestBody UserRequest request, @PathVariable int userId){
            
            this.userService.update(request, userId);
          return ResponseEntity.ok(Boolean.TRUE);
        }
        
        
        
}
