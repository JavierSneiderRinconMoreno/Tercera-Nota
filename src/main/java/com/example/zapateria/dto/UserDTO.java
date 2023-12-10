package com.example.zapateria.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	
	private String id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private Date createdAt;
	private Date updateAt;

}
