package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;
import spring.Client2;

public class Main {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconf.xml");
		
		Client client1 = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		System.out.println(client1);
		System.out.println(client2);
		
		ctx.close();
		
		
	}





}
