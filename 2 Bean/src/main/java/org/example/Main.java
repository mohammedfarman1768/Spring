package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextBean.xml");

        EmailService service = (EmailService) context.getBean("beanone");
        service.send("Hello from XML Bean!");
    }
}
