package cn.itcast.ssm.persist.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 持久层实现的基类
 */
@Repository
public class BaseImpl {

	// sql name space
	protected static final String NAME_SPACE_HEADER = "cn.itcast.ssm.persist.sql";

	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
}
