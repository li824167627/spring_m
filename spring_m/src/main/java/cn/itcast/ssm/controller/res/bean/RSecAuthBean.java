package cn.itcast.ssm.controller.res.bean;


/**
 * 用户保安信息
 **/
public class RSecAuthBean {
	private String secId; // 用户uid
	private String token; // 用户登录返回的token
	private String phone; // 用户phone
	private String name; // 用户姓名
	private Integer gender; // 用户性别，1：男，2：女
	private String idNo; // 身份证
	private String icon; // 用户头像
	private Integer isSetPwd; // 是否设置密码:1已设置，0未设置
	private String ext; // 认证提交信息对象
	private Integer state; // 保安认证，-1未认证 0等待审核，1认证通过，2认证失败
	private String height; // 身高
	private String health; // 健康1良好2一般
	private String photo; // 全身照
	private String station; // 岗位1保安员、2安全官、3培训师，必填
	private String secNo; // 保安编号
	private String qualified; // 保安员资格1待培训、2初级保安员、3中级保安员、4高级保安员、5保安师、6高级保安师
	private String reason; // 审核失败原因
	private String propertyName; // 物业
	private String plotName; // 小区
	private String plotBoxName; // 岗亭
	private Long actionTime; // 审核时间
	private String actionId; // 审核员
	private String actionName; // 审核员
	private Integer isAllot; // 保安分配状态 0未分配1未通过

	public void setSecId(String secId) {
 		this.secId = secId;
	}

	public String getSecId() {
 		return secId;
	}

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

	public void setIdNo(String idNo) {
 		this.idNo = idNo;
	}

	public String getIdNo() {
 		return idNo;
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

	public void setExt(String ext) {
 		this.ext = ext;
	}

	public String getExt() {
 		return ext;
	}

	public void setState(Integer state) {
 		this.state = state;
	}

	public Integer getState() {
 		return state;
	}

	public void setHeight(String height) {
 		this.height = height;
	}

	public String getHeight() {
 		return height;
	}

	public void setHealth(String health) {
 		this.health = health;
	}

	public String getHealth() {
 		return health;
	}

	public void setPhoto(String photo) {
 		this.photo = photo;
	}

	public String getPhoto() {
 		return photo;
	}

	public void setStation(String station) {
 		this.station = station;
	}

	public String getStation() {
 		return station;
	}

	public void setSecNo(String secNo) {
 		this.secNo = secNo;
	}

	public String getSecNo() {
 		return secNo;
	}

	public void setQualified(String qualified) {
 		this.qualified = qualified;
	}

	public String getQualified() {
 		return qualified;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

	public void setPropertyName(String propertyName) {
 		this.propertyName = propertyName;
	}

	public String getPropertyName() {
 		return propertyName;
	}

	public void setPlotName(String plotName) {
 		this.plotName = plotName;
	}

	public String getPlotName() {
 		return plotName;
	}

	public void setPlotBoxName(String plotBoxName) {
 		this.plotBoxName = plotBoxName;
	}

	public String getPlotBoxName() {
 		return plotBoxName;
	}

	public void setActionTime(Long actionTime) {
 		this.actionTime = actionTime;
	}

	public Long getActionTime() {
 		return actionTime;
	}

	public void setActionId(String actionId) {
 		this.actionId = actionId;
	}

	public String getActionId() {
 		return actionId;
	}

	public void setActionName(String actionName) {
 		this.actionName = actionName;
	}

	public String getActionName() {
 		return actionName;
	}

	public void setIsAllot(Integer isAllot) {
 		this.isAllot = isAllot;
	}

	public Integer getIsAllot() {
 		return isAllot;
	}

}
