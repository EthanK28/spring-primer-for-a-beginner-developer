package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Client implements InitializingBean, DisposableBean {
	
	private  String host;

	public void setHost(String host) {
		this.host = host;
		System.out.println("Client.setHost()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.print("Client.destroy() 실행");
	}
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.after PropertiesSet() 실행"); 
	}

}
