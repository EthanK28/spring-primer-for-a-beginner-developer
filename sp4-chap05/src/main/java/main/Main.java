package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.ConfigPart1;
import config.ConfigPart2;
import config.JavaConfig2;
import config.JavaMainConf;
import spring.AlreadyExistingMemberException;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:main-conf.xml");
		
		MemberRegisterService reqSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("madvirus@madvirus.net");
		regReq.setName("최범균");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		reqSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("madvirus@madvirus.net");
		
		
		
		
	}





}
