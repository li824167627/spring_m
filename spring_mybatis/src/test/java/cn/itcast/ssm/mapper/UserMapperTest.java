package cn.itcast.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.User;

public class UserMapperTest {

	private ApplicationContext applicationContext;

	//在setup这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		
	}

	@Test
	public void test() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testad() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		userMapper.deleteUserById(6);
		
	}
	

}
