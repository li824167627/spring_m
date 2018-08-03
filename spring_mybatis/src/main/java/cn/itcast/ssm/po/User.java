package cn.itcast.ssm.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	//属性名和数据库表的字段对应
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}
	
	
	
}
