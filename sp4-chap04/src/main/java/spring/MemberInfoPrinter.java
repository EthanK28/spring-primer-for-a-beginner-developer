package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	
	
	@Resource
	private MemberDao memDao;
	private MemberPrinter printer;
	
	
	public void injectDependency(MemberDao memberDao, MemberPrinter printer){
		this.memDao = memberDao;
		this.printer = printer;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Resource
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.print("������ ����\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
		
	}
}
