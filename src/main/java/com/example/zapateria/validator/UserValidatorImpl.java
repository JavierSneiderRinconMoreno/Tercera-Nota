

package com.example.zapateria.validator;

import com.example.zapateria.dto.UserRequest;
import com.example.zapateria.util.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {



    @Override
    public void validator(UserRequest request) throws ApiUnprocessableEntity {
        if(request.getFirstname() == null || request.getFirstname().isEmpty()){
            this.mensaje("El nombre es obligatorio");
        }
        
        if(request.getFirstname().length() < 3){
            this.mensaje("El nombre es muy corto debe tener minimo tres carateres");
        }
        
        if(request.getLastname() == null || request.getLastname().isEmpty()){
            this.mensaje("El apellido es obligatorio");
        }
        
        if(request.getLastname().length() < 3){
            this.mensaje("El apellido es muy corto debe tener minimo tres carateres");
        }
        
        if(request.getUsername()== null || request.getLastname().isEmpty()){
            this.mensaje("El usuario es obligatorio");
        }
        
        if(request.getUsername().length() < 3){
            this.mensaje("El usuario es muy corto debe tener minimo tres carateres");
        }
        
         if(request.getPassword()== null || request.getLastname().isEmpty()){
            this.mensaje("La contraseña  es obligatorio");
        }
        
        if(request.getPassword().length() < 7){
            this.mensaje("La contraseña es muy corto debe tener minimo siete carateres");
        }
    }
    
    private void mensaje (String mensaje) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(mensaje);
    }
    
    
}
