package com.springapp.boot.service;

import com.springapp.boot.domain.Greeting;
import com.springapp.boot.domain.MyDataObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author :rasikaw
 * @version :1.0
 * @since :4/29/2016
 */
@Service
public class FactoryDataService {
    /*@Autowired
    MyDataObject myDataObject;*/
/*
    @Bean
    public MyDataObject getStoredProcedure() {
        return new MyDataObject();
    }*/

    public boolean getMyData(Greeting greeting){

//        MyDataObject myDataObject = new MyDataObject(greeting);
        MyDataObject dataObject = FacIns.getInstance(greeting);

        System.out.println(dataObject);
        dataObject.say();
        return true;

    }

}
