package com.springapp.boot.concept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {

 @Autowired
 private ParserFactory parserFactory;

 public void doParse(String parseString, ParserType parseType) {
    Parser parser = parserFactory.getParser(parseType);
    System.out.println("ParserService.doParse.." + parser);
    parser.parse(parseString);
 }
}