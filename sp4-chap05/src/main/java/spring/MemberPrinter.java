package spring;

public class MemberPrinter {
	
	public void print(Member member) {
		System.out.printf("ȸ�� ����: ID=%d , Email=%s, Name=%s, �����=%tF\n", 
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDate());
	}
}
