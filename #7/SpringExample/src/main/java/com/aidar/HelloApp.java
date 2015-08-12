package com.aidar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
        GreetingService greetingService=(GreetingService)context.getBean("greetingService");
        greetingService.sayGreeting();
    }
}
