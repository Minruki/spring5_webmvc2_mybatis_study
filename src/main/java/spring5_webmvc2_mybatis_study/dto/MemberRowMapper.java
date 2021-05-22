package spring5_webmvc2_mybatis_study.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(rs.getString("email")
														  , rs.getString("name")
														  , rs.getString("password")
														  , rs.getTimestamp("regdate").toLocalDateTime());
		member.setId(rs.getLong("id"));
		return member;
	}

	

}