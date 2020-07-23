package com.pz.SpringMail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author jangachary
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SendMail mm = (SendMail) context.getBean("sendMail");
		String message = mm.sendMail("tomail@gmail.com");
		System.out.println(message);
	}
}
