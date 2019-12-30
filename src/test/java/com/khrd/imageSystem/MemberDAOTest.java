package com.khrd.imageSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.MemberVO;
import com.khrd.persistence.MemberDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testRegist() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user");
		vo.setUserpw("pass");
		vo.setUsernm("name");
		vo.setEmail("email@email.com");
		vo.setTel("010-1111-2222");
		dao.regist(vo);
	}
}
