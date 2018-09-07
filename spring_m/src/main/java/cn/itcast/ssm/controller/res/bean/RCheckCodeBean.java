package cn.itcast.ssm.controller.res.bean;


/**
 * 检查手机验证码
 **/
public class RCheckCodeBean {
	private String checkToken; // 检查手机token，15分钟有效

	public void setCheckToken(String checkToken) {
 		this.checkToken = checkToken;
	}

	public String getCheckToken() {
 		return checkToken;
	}

}
