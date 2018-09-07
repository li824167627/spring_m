package cn.itcast.ssm.persist.dao;

import cn.itcast.ssm.model.UserAuthBean;
import cn.itcast.ssm.model.UserAuthLogBean;

public interface UserAuthDao {

	UserAuthBean selectAuthByUid(String id);

	int update(UserAuthBean auth);

	int insert(UserAuthBean auth);

	int insertAuthLog(UserAuthLogBean authLog);

}
