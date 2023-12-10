
package com.example.zapateria.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception persomalizada de 404
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception {
    
    public ApiNotFound (String mensaje){
        super(mensaje);
    }
    
}
