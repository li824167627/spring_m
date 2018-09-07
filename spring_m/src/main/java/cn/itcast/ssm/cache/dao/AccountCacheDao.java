package cn.itcast.ssm.cache.dao;

public interface AccountCacheDao {

	public boolean setVCode(int type, String phone, String vcode, long expireTime);

	public String getVCode(int type, String phone);

	public boolean clearVCode(int type, String phone);

	public boolean setToken(String token, String uid, long expireTime);

	/**
	 * 通过token查询uid
	 * 
	 * @param token
	 * @return
	 */
	public String getUidByToken(String token);

	/**
	 * 通过token 获取用户uid
	 * 
	 * @param token
	 * @param delayTime
	 *            延时
	 * @return
	 */
	public String getUidByToken(String token, Long delayTime);

	/**
	 * 通过uid获取用户token
	 * 
	 * @param uid
	 */
	public String getTokenByUid(String uid);

	/**
	 * 清空用户token 和 uid
	 * 
	 * @param uid
	 * @return
	 */
	public boolean clearTokenAndUid(String uid);

	/**
	 * 检查手机号--检查token
	 * 
	 * @param type
	 * 
	 * @param phone
	 * @param checkToken
	 */
	public boolean setCheckPhoneToken(int type, String phone, String checkToken);

	/**
	 * 通过检查token 获取手机号
	 * 
	 * @param checkToken
	 * @return
	 */
	public String getPhoneByCheckToken(int type, String checkToken);

	/**
	 * 根据checkToken 清空
	 * 
	 * @param checkToken
	 * @return
	 */
	public boolean clearPhoneCheckToken(String checkToken);

	public boolean setOrderToken(String token, String uid, long expireTime);

	/**
	 * 通过token查询oid
	 * 
	 * @param token
	 * @return
	 */
	public String getUidByOrderToken(String token);

	/**
	 * 通过token 获取Oid
	 * 
	 * @param token
	 * @param delayTime
	 *            延时
	 * @return
	 */
	public String getUidByOrderToken(String token, Long delayTime);

	/**
	 * 清空用户token 和 uid
	 * 
	 * @param uid
	 * @return
	 */
	public boolean clearOrderTokenAndUid(String uid);

	// ====================保安========================

	/**
	 * 通过token查询保安id
	 * 
	 * @param token
	 * @return
	 */
	public String getSecIdByToken(String token);

	/**
	 * 通过token 获取保安id
	 * 
	 * @param token
	 * @param delayTime
	 *            延时
	 * @return
	 */
	public String getSecIdByToken(String token, Long delayTime);

	/**
	 * 通过uid获取保安token
	 * 
	 * @param uid
	 */
	public String getTokenBySecId(String secId);

	/**
	 * 清空保安token 和 uid
	 * 
	 * @param uid
	 * @return
	 */
	public boolean clearTokenAndSecId(String secId);

	boolean setSecToken(String token, String secId, long expireTime);

	/**
	 * 获取保安端验证码
	 * 
	 * @param type
	 * @param phone
	 * @return
	 */
	public String getSecVCode(int type, String phone);

	boolean setSecVCode(int type, String phone, String vcode, long expireTime);

	/**
	 * 检查手机号--检查token
	 * 
	 * @param phone
	 * @param checkToken
	 */
	public boolean setSecCheckPhoneToken(int type, String phone, String checkToken);

	/**
	 * 通过检查token 获取手机号
	 * 
	 * @param checkToken
	 * @return
	 */
	public String getSecPhoneByCheckToken(int type, String checkToken);

	/**
	 * 根据checkToken 清空
	 * 
	 * @param checkToken
	 * @return
	 */
	public boolean clearSecPhoneCheckToken(String checkToken);

}
