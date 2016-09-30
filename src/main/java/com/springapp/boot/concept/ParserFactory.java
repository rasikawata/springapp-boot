package com.springapp.boot.concept;

public interface ParserFactory {
  public Parser getParser(ParserType parserType);
}