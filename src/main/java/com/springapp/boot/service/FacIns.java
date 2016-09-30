package com.springapp.boot.service;

import com.springapp.boot.domain.Greeting;
import com.springapp.boot.domain.MyDataObject;
import org.springframework.context.annotation.Bean;

/**
 * @author :rasikaw
 * @version :1.0
 * @since :4/29/2016
 */
public class FacIns {

    @Bean
    public static MyDataObject getInstance(Greeting greeting){
        return new MyDataObject(greeting);
    }
}
