/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.zapateria.validator;

import com.example.zapateria.dto.UserRequest;
import com.example.zapateria.util.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 * Interfas de validacion para creacion de usuarios 
 */
@Service
public interface UserValidator {
    void validator(UserRequest request) throws ApiUnprocessableEntity;
}
