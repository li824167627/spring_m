package cn.itcast.ssm.controller.res.bean;


/**
 * 返回用户信息
 **/
public class RUserBean {
	private String token; // 用户登录返回的token
	private String phone; // 用户phone
	private String id; // 用户uid
	private String name; // 用户姓名
	private Integer gender; // 用户性别，1：男，2：女
	private String letter; // 字符串的第一个字符的首字母
	private String icon; // 用户头像
	private Integer isSetPwd; // 是否设置密码:1已设置，0未设置
	private RUserAuthBean userAuth; // 用户认证信息
	private RSecAuthBean secAuth; // 用户保安认证信息
	private Integer authState; // 是否认证-1未申请0，申请中 1已通过 1 未通过
	private Integer securityState; // 是否是保安 -1未提交0提交1通过2未通过
	private Integer secAllotState; // 保安分配状态 0未分配1未通过

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setPhone(String phone) {
 		this.phone = phone;
	}

	public String getPhone() {
 		return phone;
	}

	public void setId(String id) {
 		this.id = id;
	}

	public String getId() {
 		return id;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setGender(Integer gender) {
 		this.gender = gender;
	}

	public Integer getGender() {
 		return gender;
	}

	public void setLetter(String letter) {
 		this.letter = letter;
	}

	public String getLetter() {
 		return letter;
	}

	public void setIcon(String icon) {
 		this.icon = icon;
	}

	public String getIcon() {
 		return icon;
	}

	public void setIsSetPwd(Integer isSetPwd) {
 		this.isSetPwd = isSetPwd;
	}

	public Integer getIsSetPwd() {
 		return isSetPwd;
	}

	public void setUserAuth(RUserAuthBean userAuth) {
 		this.userAuth = userAuth;
	}

	public RUserAuthBean getUserAuth() {
 		return userAuth;
	}

	public void setSecAuth(RSecAuthBean secAuth) {
 		this.secAuth = secAuth;
	}

	public RSecAuthBean getSecAuth() {
 		return secAuth;
	}

	public void setAuthState(Integer authState) {
 		this.authState = authState;
	}

	public Integer getAuthState() {
 		return authState;
	}

	public void setSecurityState(Integer securityState) {
 		this.securityState = securityState;
	}

	public Integer getSecurityState() {
 		return securityState;
	}

	public void setSecAllotState(Integer secAllotState) {
 		this.secAllotState = secAllotState;
	}

	public Integer getSecAllotState() {
 		return secAllotState;
	}

}
