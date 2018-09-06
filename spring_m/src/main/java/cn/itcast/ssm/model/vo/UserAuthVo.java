package cn.itcast.ssm.model.vo;

import cn.itcast.ssm.model.UserAuthBean;
import cn.itcast.ssm.model.UserBean;

/**
 * 用户及用户验证信息
 */
public class UserAuthVo extends UserBean {

	private UserAuthBean auth;

	public UserAuthBean getAuth() {
		return auth;
	}

	public void setAuth(UserAuthBean auth) {
		this.auth = auth;
	}

}
