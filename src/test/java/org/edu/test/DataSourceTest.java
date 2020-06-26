package org.edu.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.edu.service.IF_MemberService;
import org.edu.vo.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class DataSourceTest {// 스프링 프로젝트 테스트는 여기서 다 합니다!

	@Inject
	private DataSource ds;

	@Inject
	private IF_MemberService memberService;

	@Test
	public void testconnection() throws Exception {
		Connection con = ds.getConnection();
		System.out.println("데이터베이스 커넥션 성공 : " + con);
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		memberService.deleteMember("user02");
	}

	@Test
	public void testUpdateMember() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("user02");
		memberVO.setUser_pw("1234");
		memberVO.setUser_name("배기열");
		memberVO.setEmail("giyeol@test.com");
		memberVO.setPoint(100);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_USER");
		memberService.updateMember(memberVO);
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("baegiyeol");
		memberVO.setUser_pw("1234");
		memberVO.setUser_name("배기열");
		memberVO.setEmail("giyeol@test.com");
		memberVO.setPoint(100);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_USER");
		memberService.insertMember(memberVO);
	}

	@Test
	public void testSelectMember() throws Exception {
		System.out.println("회원리스트 입니다.");
		memberService.selectMember();
		
		/*
		 * List<MemberVO> list = memberService.selectMember(); for(MemberVO vo:list) {
		 * System.out.println("사용자아이디 : "+ vo.getUser_id());
		 * System.out.println("사용자이메일 : " + vo.getEmail());
		 */
	}

}
