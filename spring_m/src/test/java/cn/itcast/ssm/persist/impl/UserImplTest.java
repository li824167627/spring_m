package cn.itcast.ssm.persist.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:*spring-mvc.xml", "classpath:*application-context.xml",
		"classpath:*spring-mybatis.xml", "classpath:*spring-redis.xml" })
public class UserImplTest {
	


	@Before
	public void setUp() throws Exception {
		
	}
	@Autowired
	UserImpl userImpl;
	UserAuthImpl userAuthImpl;
	
	@Test
	public void testselectAuthByUid() {
		System.out.println(userAuthImpl);
	}

	@Test
	public void testSelectOneByPhone() {
//		UserAuthVo userAuthVo = userImpl.selectOneByPhone("18010483452");
		System.out.println(userImpl.selectOneByPhone("18010483452"));
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateLoginTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectOneByOpenId() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertThird() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectOneByUid() {
		System.out.println(userImpl.selectAuthVoByUid("01c4ad60dd164fb7bab28dd7b6e478fc"));
	}

	@Test
	public void testSelectAuthVoByUid() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectListByIds() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectListAll() {
		fail("Not yet implemented");
	}
	

}

