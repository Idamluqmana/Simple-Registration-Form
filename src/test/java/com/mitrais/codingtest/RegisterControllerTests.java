package com.mitrais.codingtest;

import com.mitrais.codingtest.controllers.RegisterController;
import com.mitrais.codingtest.entities.Register;
import com.mitrais.codingtest.services.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.AssertTrue;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RegisterControllerTests {

    @Autowired
    private RegisterController registerController;

    //ini test buat masuk register page
    @Test
    public void showRegistrationPageTest(){
        ModelAndView mav = new ModelAndView();
        Register reg = mock(Register.class);
        mav.setViewName("register");
        ModelAndView result = registerController.showRegistrationPage(mav,reg);
        assertEquals("register",result.getViewName());
    }

    //ini test kalo email sudah ke daftar
    @Test
    public void processRegistrationFormTestUserAlreadyExists(){
        ModelAndView mav = new ModelAndView();
        RegisterService regService = mock(RegisterService.class);
        Register reg = new Register();
        reg.setMobileNumber("+6281329729429");
        reg.setDateBirth("19-12-1996");
        reg.setFirstName("Idam");
        reg.setLastName("Luqmana");
        reg.setGender("Male");
        reg.setEmail("idamluqmana@gmail.com");
        BindingResult br = mock(BindingResult.class);
        HttpServletRequest http = mock(HttpServletRequest.class);

        when(regService.findByEmail(reg.getEmail())).thenReturn(reg);
        mav.setViewName("register");
        mav.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");

        ModelAndView result = registerController.processRegistrationForm(mav,reg,br,http);
        assertTrue(result.getModel().containsKey("alreadyRegisteredMessage"));
        assertEquals("register",result.getViewName());
    }

    //ini test jika inputan salah
    @Test
    public void processRegistrationFormTestErrorPropertyNotProper(){
        ModelAndView mav = new ModelAndView();
        BindingResult br = mock(BindingResult.class);
        HttpServletRequest http = mock(HttpServletRequest.class);
        Register reg = new Register();
        reg.setMobileNumber("+1181329729429"); //number format salah
        reg.setDateBirth("19-12-1996");
        reg.setFirstName("Idam");
        reg.setLastName("Luqmana");
        reg.setGender("Male");
        reg.setEmail("idamlukmana@gmail.com");

        when(br.hasErrors()).thenReturn(true);
        mav.setViewName("register");

        ModelAndView result = registerController.processRegistrationForm(mav,reg,br,http);
        assertEquals("register",result.getViewName());
    }

    //ini test jika inputan benar dan sukses submit register
    @Test
    public void processRegistrationFormTestErrorPropertyProper(){
        ModelAndView mav = new ModelAndView();
        BindingResult br = mock(BindingResult.class);
        HttpServletRequest http = mock(HttpServletRequest.class);

        when(br.hasErrors()).thenReturn(false);
        mav.addObject("SuccessMessage", "Register Successfull");
        mav.setViewName("register");
        Register reg = new Register();
        reg.setMobileNumber("+6281329729429");
        reg.setDateBirth("19-12-1996");
        reg.setFirstName("Idam");
        reg.setLastName("Luqmana");
        reg.setGender("Male");
        reg.setEmail("idamlukmana@gmail.com");
        ModelAndView result = registerController.processRegistrationForm(mav,reg,br,http);
        assertTrue(result.getModel().containsKey("SuccessMessage"));
        assertEquals("register",result.getViewName());
    }

    @Test
    public void showLoginPageTest(){
        ModelAndView mav = new ModelAndView();
        Register reg = mock(Register.class);
        mav.setViewName("register");
        ModelAndView result = registerController.showRegistrationPage(mav,reg);
        assertEquals("register",result.getViewName());
    }
}
