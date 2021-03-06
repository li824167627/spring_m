package cn.itcast.ssm.model;

import java.sql.Timestamp;

/**
 * 用户列表信息
 **/
public class UserAuthLogBean {
	private Integer id; // 用户认证id
	private String userId; // 用户uid
	private String name;// 姓名
	private Integer gender;// 性别：1男， 2女
	private String idNo; // 身份证
	private String ext; // 认证提交信息对象
	private Integer state; // 0提交 1审核通过 2审核未通过
	private Timestamp actionTime; // 审核时间
	private String actionId; // 审核员
	private String actionName; // 审核员

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdNo() {
		return idNo;
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

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

}
