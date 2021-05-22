package spring5_webmvc2_mybatis_study.mapper;

import java.util.List;

import spring5_webmvc2_mybatis_study.dto.Member;

public interface MemberMapper {
	

	int insertMember(Member member);
	
	int deleteMember(Member member);
	
	int updateMember(Member member);
	
	int countMember();

	Member selectByEmail(String string);

	List<Member> selectAll();




}