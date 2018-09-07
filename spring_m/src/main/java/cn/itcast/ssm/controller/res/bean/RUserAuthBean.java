package cn.itcast.ssm.controller.res.bean;


/**
 * 用户认证信息
 **/
public class RUserAuthBean {
	private Integer id; // 用户认证id
	private String userId; // 用户uid
	private String name; // 用户姓名
	private Integer gender; // 用户性别，1：男，2：女
	private String idNo; // 身份证
	private String ext; // 认证提交信息对象
	private Integer state; // 0提交 1审核通过  2审核未通过
	private String reason; // 驳回原因
	private Long actionTime; // 审核时间
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

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
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

}
