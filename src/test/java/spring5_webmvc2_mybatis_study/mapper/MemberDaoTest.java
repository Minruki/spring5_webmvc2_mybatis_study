package spring5_webmvc2_mybatis_study.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc2_mybatis_study.config.ContextRoot;
import spring5_webmvc2_mybatis_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberDaoTest {
	protected static final Log log = LogFactory.getLog(MemberDaoTest.class);
	
	@Autowired
	private MemberMapper mapper;
	 
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01selectAll() {
		System.out.println("test01selectAll");
		List<Member> list = mapper.selectAll();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}

	@Test
	public void test02insertMember() {
		System.out.println("test02insertMember");
		Member addMember = new Member("min2@naver.com", "123123", "testtest");
		int res = mapper.insertMember(addMember);
		Assert.assertEquals(1,res);
		System.out.println(addMember);
	}
	
	@Test
	public void test03selectMemberByEmail() {
		System.out.println("test03selectMemberByEmail");
		Member addMember = mapper.selectByEmail("min2@naver.com");
		Assert.assertNotNull(addMember);
	}
	
	@Test
	public void test05CountMember() {
		
		System.out.println("test05CountMember");
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int cnt = mapper.countMember();
		
		Assert.assertNotEquals(-1, cnt);
		log.debug("cnt >> " + cnt);
		
	}
	
	@Test
	public void test04UpdateMember() {
		System.out.println("test04UpdateMember");
		Member member = new Member("min2@naver.com", "123456", "1111111");
		int res = mapper.updateMember(member);
		Assert.assertEquals(1,res);
	}
	
	@Test
	public void test06DeleteMember() {
		System.out.println("test06DeleteMember");
		Member member = new Member();
		member.setEmail("min2@naver.com");
		int res = mapper.deleteMember(member);
		Assert.assertEquals(1, res);
	}
}