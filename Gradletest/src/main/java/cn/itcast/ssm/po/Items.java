package cn.itcast.ssm.po;

import java.util.List;

//包装类型
public class Items {
	private List<Integer> ids;
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//这里包装所需要的查询条件
	private UserCustom userCustom;
	//用户查询条件

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	
}
