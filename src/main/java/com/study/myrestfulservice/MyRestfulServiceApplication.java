package com.study.myrestfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class MyRestfulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRestfulServiceApplication.class, args);

//        String[] allBeanNames = ac.getBeanDefinitionNames();
//        for (String beanName : allBeanNames) {
//            System.out.println(beanName);
//        }
    }

    @Bean
    public SessionLocaleResolver localResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

}
