package com.springapp.boot.concept;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.springapp.boot.concept"})
public class AppConfig {
 @Bean
 public FactoryBean serviceLocatorFactoryBean() {
    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(ParserFactory.class);
    return factoryBean;
 }

 @Bean(name = "jsonParser")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public JsonParser jsonParser() {
    return new JsonParser();
 }

 @Bean(name = "xmlParser")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public XMLParser xmlParser() {
    return new XMLParser();
 }
}