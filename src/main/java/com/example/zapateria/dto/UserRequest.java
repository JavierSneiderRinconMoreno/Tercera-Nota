
package com.example.zapateria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRequest {
    
        @JsonProperty("firstname")
	private String firstname;
        @JsonProperty("lastname")
	private String lastname;
        @JsonProperty("username")
	private String username;  
        @JsonProperty("password")
	private String password;
                
    
}
