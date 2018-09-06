package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.User;

public interface UserMapper {
	
//	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;       
	public void deleteUserById(Integer id) throws Exception;
	
	
}
