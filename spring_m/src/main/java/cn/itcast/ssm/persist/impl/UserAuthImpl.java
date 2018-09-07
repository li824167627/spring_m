package cn.itcast.ssm.persist.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.ssm.model.UserAuthBean;
import cn.itcast.ssm.model.UserAuthLogBean;
import cn.itcast.ssm.persist.dao.UserAuthDao;

@Repository
public class UserAuthImpl extends BaseImpl implements UserAuthDao {

	final String NAME_SPACE = NAME_SPACE_HEADER + ".UserAuthMapper";

	@Override
	public UserAuthBean selectAuthByUid(String userId) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".selectAuthByUid", userId);

	}

	@Override
	public int update(UserAuthBean auth) {
		return sqlSessionTemplate.update(NAME_SPACE + ".update", auth);
	}

	@Override
	public int insert(UserAuthBean auth) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insert", auth);
	}

	@Override
	public int insertAuthLog(UserAuthLogBean authLog) {
		return sqlSessionTemplate.insert(NAME_SPACE + ".insertAuthLog", authLog);
	}

}
