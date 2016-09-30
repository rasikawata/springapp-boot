package com.springapp.boot.controllers;

import com.springapp.boot.domain.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class CrossDomainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*not works with JDK 1.7*/
    //@CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/greet")
    public @ResponseBody Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greet-javaconfig")
    public @ResponseBody Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}