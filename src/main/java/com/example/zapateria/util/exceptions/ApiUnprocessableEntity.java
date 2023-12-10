
package com.example.zapateria.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Exception persomalizada de 422
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception {
    
    public ApiUnprocessableEntity (String mensaje){
        super(mensaje);
    }
    
}
