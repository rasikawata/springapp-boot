package com.springapp.boot.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author :rasikaw
 * @version :1.0
 * @since :4/29/2016
 */
@Service
public class MyDataObject {

    @Autowired
    Student student;

    /*@Bean
    private void getStu(){
        student = new Student();
    }*/
    public MyDataObject(Greeting greeting) {
        student.setSection(greeting.getContent());

        System.out.println(student);
    }


    public void say(){
        //getStu();
        System.out.println("say - " + student);
    }

    @Override
    public String toString() {
        return "MyDataObject{" +
                "student=" + student +
                '}';
    }
}
