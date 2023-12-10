
package com.example.zapateria.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception persomalizada de 404
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorizazed extends Exception{
    
    public ApiUnauthorizazed(String mensaje){
        super(mensaje);
    }
    
}
