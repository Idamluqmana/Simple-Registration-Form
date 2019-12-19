package com.mitrais.codingtest.controllers;

import com.mitrais.codingtest.entities.Register;
import com.mitrais.codingtest.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, Register register){
        modelAndView.addObject("disable",false);
        modelAndView.addObject("register", register);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Register register, BindingResult bindingResult, HttpServletRequest request) {

        // Lookup user in database by e-mail
        Register userExists = registerService.findByEmail(register.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            registerService.saveUser(register);

            modelAndView.addObject("SuccessMessage", "Register Successfull");
            modelAndView.addObject("disable",true);
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelAndView modelAndView, Register register){
        modelAndView.addObject("disable",false);
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
