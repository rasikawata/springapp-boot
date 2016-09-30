package com.springapp.boot.controllers;

import com.springapp.boot.domain.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Validating Form Input
 * The Thymeleaf configuration is also taken care of by @SpringBootApplication: by default templates are located in the
 * classpath under templates/ and are resolved as views by stripping the '.html' suffix off the file name.
 * Thymeleaf settings can be changed and overridden in a variety of ways depending on what you need to achieve
 */
@Controller
@RequestMapping("/webForm")
public class WebFormController{

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String showForm(PersonForm personForm, Model model) {
        return "form";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        System.out.println("test");
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/webForm/results";
    }

    @RequestMapping(value="/results", method= RequestMethod.GET)
    public String showResult() {
        return "results";
    }
}