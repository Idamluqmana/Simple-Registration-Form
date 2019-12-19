package com.mitrais.codingtest.services;

import com.mitrais.codingtest.entities.Register;
import com.mitrais.codingtest.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;


    public Register findByEmail(String email) {
        return registerRepository.findByEmail(email);
    }

    public void saveUser(Register register) {
        registerRepository.save(register);
    }

}