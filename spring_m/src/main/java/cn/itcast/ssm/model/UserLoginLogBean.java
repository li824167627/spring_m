package cn.itcast.ssm.model;

import java.sql.Timestamp;

/**
 * 用户登录日志
 */
public class UserLoginLogBean {
	private Integer id;
	private String uid;
	private String deviceId; // 设备id
	private String os; // 操作系统
	private String model; // 机型
	private String resolution; // 分辨率
	private Integer fromType; // 0：web，1：ios，2：android
	private String data; // 记录用户的登录数据
	private Timestamp oTime; // 登录时间
	private Integer otype; // 操作类型，1：登录，2：注册
	private Integer state; // 状态，0：失败，1：成功，2：密码不正确，3：用户被禁用，4：用户切换保安，5:保安切换用户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Integer getFromType() {
		return fromType;
	}

	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Timestamp getoTime() {
		return oTime;
	}

	public void setoTime(Timestamp oTime) {
		this.oTime = oTime;
	}

	public Integer getOtype() {
		return otype;
	}

	public void setOtype(Integer otype) {
		this.otype = otype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
