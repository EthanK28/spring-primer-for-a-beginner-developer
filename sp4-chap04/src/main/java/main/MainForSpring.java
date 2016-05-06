package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("��ɾ �Է��ϼ���:");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("�����մϴ�");
				break;
			}
			
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}  else if (command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			}
			
			printHelp();
			
		}
		
		
		
	}



	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService reqSvc = ctx.getBean("memberRegSvc", 
				MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("��ȣ�� Ȯ���� ��ġ���� �Ƚ��ϴ�. \n");
		}
		
		try {
			reqSvc.regist(req);
			System.out.println("����߽��ϴ�. \n");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("�̹� �����ϴ� �̸����Դϴ�. \n");
		}
		
	}
	

	
	private static void processInfoCommand(String[] arg) {
		if (arg.length != 2) {
			printHelp();
			return;
		}
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("�߸��� ����Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("��ɾ� ����: ");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� ������ ������");
		System.out.println();
	}

}
