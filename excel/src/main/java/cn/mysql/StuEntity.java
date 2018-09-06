package cn.mysql;

import java.util.Date;

public class StuEntity {
    private int id;
    private String organization;
    private String company;
    private String username;
    private String nickname;
    private String mailbox;
    private int phone;
    private int officephone;
    private String employeecoding;
    private String employeename;
    private Date Lastlogindate;
    
    
    
    
    
    public StuEntity() {
    }





	public StuEntity(int id, String organization, String company, String username, String nickname, String mailbox,
			int phone, int officephone, String employeecoding, String employeename, Date lastlogindate) {
		super();
		this.id = id;
		this.organization = organization;
		this.company = company;
		this.username = username;
		this.nickname = nickname;
		this.mailbox = mailbox;
		this.phone = phone;
		this.officephone = officephone;
		this.employeecoding = employeecoding;
		this.employeename = employeename;
		this.Lastlogindate = lastlogindate;
	}





	@Override
	public String toString() {
		return "StuEntity [id=" + id + ", organization=" + organization + ", company=" + company + ", username="
				+ username + ", nickname=" + nickname + ", mailbox=" + mailbox + ", phone=" + phone + ", officephone="
				+ officephone + ", employeecoding=" + employeecoding + ", employeename=" + employeename
				+ ", Lastlogindate=" + Lastlogindate + "]";
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getOrganization() {
		return organization;
	}





	public void setOrganization(String organization) {
		this.organization = organization;
	}





	public String getCompany() {
		return company;
	}





	public void setCompany(String company) {
		this.company = company;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getNickname() {
		return nickname;
	}





	public void setNickname(String nickname) {
		this.nickname = nickname;
	}





	public String getMailbox() {
		return mailbox;
	}





	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}





	public int getPhone() {
		return phone;
	}





	public void setPhone(int phone) {
		this.phone = phone;
	}





	public int getOfficephone() {
		return officephone;
	}





	public void setOfficephone(int officephone) {
		this.officephone = officephone;
	}





	public String getEmployeecoding() {
		return employeecoding;
	}





	public void setEmployeecoding(String employeecoding) {
		this.employeecoding = employeecoding;
	}





	public String getEmployeename() {
		return employeename;
	}





	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}





	public Date getLastlogindate() {
		return Lastlogindate;
	}





	public void setLastlogindate(Date lastlogindate) {
		Lastlogindate = lastlogindate;
	}
   
        
    
    	
}