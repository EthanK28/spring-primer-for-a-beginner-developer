package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Client2 {
	
	private  String host;

	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2.setHost()");
	}
	
	public void connect() throws Exception {
		System.out.println("Client2.connect 실행");
	}

	
	public void close() throws Exception {
		System.out.print("Client2.close() 실행");
	}
	
	public void send() {
		System.out.println("Client2.send() to " + host);
	}



}
