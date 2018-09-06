package cn.itcast.ssm.model;

import java.sql.Timestamp;

/**
 * 用户
 */
public class UserBean {

	private String id;
	private String password;
	private String phone;
	private String name;
	private String icon;
	private String letter;
	private Integer gender;
	private String openid; // 第三方登录 openid
	private Integer isSetPwd;
	private Timestamp regTime;
	private Timestamp lastLoginTime;

	private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getIsSetPwd() {
		return isSetPwd;
	}

	public void setIsSetPwd(Integer isSetPwd) {
		this.isSetPwd = isSetPwd;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", password=" + password + ", phone=" + phone + ", name=" + name + ", icon="
				+ icon + ", letter=" + letter + ", gender=" + gender + ", openid=" + openid + ", isSetPwd=" + isSetPwd
				+ ", regTime=" + regTime + ", lastLoginTime=" + lastLoginTime + ", username=" + username + "]";
	}

}
