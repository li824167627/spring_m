package cn.itcast.ssm.dao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.User;

public class UserDaoImplTest {

	private ClassPathXmlApplicationContext applicationContext;

	//在setUP这个方法得到spring
	@Before
	public void setUp() throws Exception {
		
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void test() throws Exception {
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		//调用userDao的方法
		User user = userDao.findUserById(6);
		
		System.out.println(user);
	}

}
