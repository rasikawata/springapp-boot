package com.springapp.boot.concept;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ServiceLocatorFactoryExample {


 @Autowired
 private ParserService parserService;

 @Test
 public void testParserFactory() {
    parserService.doParse("Srilekha", ParserType.JSON);
    parserService.doParse("Srilekha", ParserType.XML);
 }
}