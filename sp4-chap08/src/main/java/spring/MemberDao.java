package spring;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class MemberDao {

	private JdbcTemplate jbdcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jbdcTemplate = new JdbcTemplate(dataSource);
	}
	
	public class MemberRowMapper implements RowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString("EMAIL"), 
					rs.getString("PASSWORD"), 
					rs.getString("NAME"), 
					rs.getTimestamp("REGDATE"));
			member.setId(rs.getLong("ID"));
			return member;
		}		
	}	
	
	public Member selectByEmail(String email) {
		List<Member> results = jbdcTemplate.query(
				"select * from MEMBER where EMAIL =?", 
				new MemberRowMapper()
				, email);
		return results.isEmpty() ? null : results.get(0);
	}

	
	public List<Member> selectAll() {
		List<Member> results = jbdcTemplate.query(
				"select * from MEMBER", 
				new MemberRowMapper());
		return results;
	}
	
	public int count() {
		Integer count = jbdcTemplate.queryForObject(
				"select count(*) from MEMBER", 
				Integer.class);
		return count;
	}
	
	public void insert(Member member){
		
	}
	
	public void update(Member member){
		jbdcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	
}
