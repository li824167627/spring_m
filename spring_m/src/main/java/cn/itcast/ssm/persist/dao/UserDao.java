package cn.itcast.ssm.persist.dao;

import java.util.List;

import cn.itcast.ssm.model.UserBean;
import cn.itcast.ssm.model.UserThirdBean;
import cn.itcast.ssm.model.vo.UserAuthVo;

public interface UserDao {

	UserAuthVo selectOneByPhone(String phone);

	int insert(UserBean newuser);

	int update(UserBean updateBean);

	int updateLoginTime(UserBean updateBean);

	UserAuthVo selectOneByOpenId(String openId);

	int insertThird(UserThirdBean third);

	UserBean selectOneByUid(String uid);

	UserAuthVo selectAuthVoByUid(String uid);

	List<UserBean> selectListByIds(List<String> uids);

	List<UserBean> selectListAll();

}
