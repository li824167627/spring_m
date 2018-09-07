package cn.itcast.ssm.controller.res.bean;


/**
 * 用户车辆信息
 **/
public class RCarInfoBean {
	private Integer id; // id
	private String uid; // 用户uid
	private String no; // 车牌号
	private String letter; // 第一个字符的首字母
	private Long creatTime; // 创建时间 时间戳

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setUid(String uid) {
 		this.uid = uid;
	}

	public String getUid() {
 		return uid;
	}

	public void setNo(String no) {
 		this.no = no;
	}

	public String getNo() {
 		return no;
	}

	public void setLetter(String letter) {
 		this.letter = letter;
	}

	public String getLetter() {
 		return letter;
	}

	public void setCreatTime(Long creatTime) {
 		this.creatTime = creatTime;
	}

	public Long getCreatTime() {
 		return creatTime;
	}

}
