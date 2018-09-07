package cn.itcast.ssm.persist.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itcast.ssm.model.vo.UserAuthVo;

public class UserDaoTest {
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");

	}

	@Test
	public void testSelectOneByPhone() throws Exception{
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		UserAuthVo userAuthVo = userDao.selectOneByPhone("18010483452");
		System.out.println(userAuthVo);
		
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
		fail("Not yet implemented");
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
