package cn.itcast.ssm.model;

import java.sql.Timestamp;

/**
 * 消息表
 * 
 * @author chengl
 *
 */
public class MessageBean {
	private Integer mid;
	private String tuid;// 目标id
	private String title;// 消息标题
	private String content;
	private Integer type;
	private Integer code;
	private String extras;
	private Timestamp addTime;
	private Integer isRead;
	private Integer loginPort;

	private String tname;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTuid() {
		return tuid;
	}

	public void setTuid(String tuid) {
		this.tuid = tuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getLoginPort() {
		return loginPort;
	}

	public void setLoginPort(Integer loginPort) {
		this.loginPort = loginPort;
	}

}
