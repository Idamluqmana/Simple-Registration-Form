package com.mitrais.codingtest;

import com.mitrais.codingtest.entities.Register;
import com.mitrais.codingtest.repositories.RegisterRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RegisterServiceTests {

    @Test
    public void findByMailTest(){
        RegisterRepository repo = mock(RegisterRepository.class);
        Register reg = repo.findByEmail("idamluqmana@gmail.com");
        assertNull(reg);

    }

    @Test
    public void saveRegisterTest(){
        RegisterRepository repo = mock(RegisterRepository.class);
        Register reg = new Register();
        reg.setMobileNumber("+6281329729429");
        reg.setDateBirth("19-12-1996");
        reg.setFirstName("Idam");
        reg.setLastName("Luqmana");
        reg.setGender("Male");
        reg.setEmail("idamlukmana@gmail.com");
        when(repo.save(reg)).thenReturn(reg);
        assertNotNull(reg);

    }
}
