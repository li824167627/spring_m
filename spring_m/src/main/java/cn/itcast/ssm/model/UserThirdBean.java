package cn.itcast.ssm.model;

import java.sql.Timestamp;

/**
 * 用户绑定三方账号
 **/
public class UserThirdBean {
	private Integer id; // 用户认证id
	private String userId; // 用户uid
	private Integer type; // 1wechat 2qq
	private String openId; //
	private Timestamp bindTime; // 绑定时间
	private Integer loginType;// 登录类型：1用户2保安

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Timestamp getBindTime() {
		return bindTime;
	}

	public void setBindTime(Timestamp bindTime) {
		this.bindTime = bindTime;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

}
