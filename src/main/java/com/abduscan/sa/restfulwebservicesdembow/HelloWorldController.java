package com.abduscan.sa.restfulwebservicesdembow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

@GetMapping(path = "/hello-world") public String helloWorld(){
    return "Hijo puta";
}

    @Autowired
    private MessageSource messageSource;


    @GetMapping(path = "/hello-world-bean") public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hijo puta");
    }

    @GetMapping(path = "/hello-world-bean-internacional") public HelloWorldBean helloWorldBeanInternacional(@RequestHeader(name="Accept-Language",required = false) Locale locale){
        return new HelloWorldBean(this.messageSource.getMessage("good.morning.message",null,locale));
    }

    @GetMapping(path = "/hello-world-bean/{name}") public HelloWorldBean helloWorldBeanParametro(@PathVariable String name){
        return new HelloWorldBean("Hijo puta" + name);
    }



}
