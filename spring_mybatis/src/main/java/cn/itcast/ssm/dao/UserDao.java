package cn.itcast.ssm.dao;

import cn.itcast.ssm.po.User;

public interface UserDao {
	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;


}
