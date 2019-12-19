package com.mitrais.codingtest;

import com.mitrais.codingtest.entities.Register;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {

    @Test
    public void whenCallIdTest(){
        Register register = new Register();
        register.setId(1);

        assertTrue(register.getId() == 1);
    }


    @Test
    public void whenCallMobileNumberTest(){
        Register register = new Register();
        register.setMobileNumber("2525");

        assertTrue(register.getMobileNumber().equals("2525"));
    }

    @Test
    public void whenCallFirstNameTest(){
        Register register = new Register();
        register.setFirstName("Idam");

        assertTrue(register.getFirstName().equals("Idam"));
    }

    @Test
    public void whenCallLastNameTest(){
        Register register = new Register();
        register.setLastName("Luqmana");

        assertTrue(register.getLastName().equals("Luqmana"));
    }

    @Test
    public void whenCallGenderTest(){
        Register register = new Register();
        register.setGender("Male");

        assertTrue(register.getGender().equals("Male"));
    }

    @Test
    public void whenCallDateBirthTest(){
        Register register = new Register();
        register.setDateBirth("19-12-1996");

        assertTrue(register.getDateBirth().equals("19-12-1996"));
    }

    @Test
    public void whenCallEmailTest(){
        Register register = new Register();
        register.setEmail("idamluqmana@gmail.com");

        assertTrue(register.getEmail().equals("idamluqmana@gmail.com"));
    }


}

