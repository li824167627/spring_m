package cn.itcast.ssm.dao;

import org.apache.ibatis.session.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	

	@Override
	public User findUserById(int id) throws Exception {
	
		//继承SqlSessionDaoSupport，通过this.getSqlSession();得到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		
		User user = sqlSession.selectOne("test.findUserById", id);
		
		return user;
	}
	
}
