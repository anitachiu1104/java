package com.zhubajie.test.dubbo02.controller;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhubajie.test.dubbo02.Math;



public class Consumer {
	
    public static void main(String[] args) {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");  
        context.start();  
        Math context1 = (Math) context.getBean("math");
    	int result = context1.add(33, 3);
    	System.out.println(result);
    }  
} 