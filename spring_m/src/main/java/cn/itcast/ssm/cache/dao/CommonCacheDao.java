package cn.itcast.ssm.cache.dao;

public interface CommonCacheDao {

	/**
	 * 设置登陆类型 1业主登陆，2保安登陆
	 * 
	 * @param phone
	 * @param type
	 * @return
	 */
	boolean setLastLoginType(String phone, int type);

	/**
	 * 得到上次登陆类型
	 * 
	 * @param phone
	 * @return
	 */
	Integer getLastLoginType(String phone);

}
