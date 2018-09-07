package cn.itcast.ssm.service;

import cn.itcast.ssm.controller.res.bean.RCheckCodeBean;
import cn.itcast.ssm.controller.res.bean.RUserAuthBean;
import cn.itcast.ssm.controller.res.bean.RUserBean;
import cn.itcast.ssm.model.UserBean;
import cn.itcast.ssm.service.exception.ServiceException;

public interface AccountService {

	/**
	 * 账户登录
	 * 
	 * @param phone
	 * @param content
	 * @param type
	 * @param loginPort
	 * @return
	 */
	RUserBean login(String phone, String password, String vcode, int type, String deviceId, String os, String model,
			int formType, String resolution, int loginPort) throws ServiceException;

	/**
	 * 第三方登录
	 * 
	 * @param openid
	 * @param icon
	 *            头像
	 * @param type
	 *            1微信 2QQ
	 * @param loginPort
	 * @param device
	 *            设备信息
	 * @return
	 */
	RUserBean thirdLogin(String openId, String icon, int type, String deviceId, String os, String model, int formType,
			String resolution, int loginPort) throws ServiceException;

	/**
	 * 第三方账号绑定手机号
	 * 
	 * @param userId
	 * @param type
	 * @param openId
	 * @param icon
	 * @param phone
	 * @param checkToken
	 * @return
	 */
	RUserBean thirdBindPhone(int type, String openId, String icon, String phone, String checkToken, int loginPort);

	/**
	 * 退出
	 * 
	 * @param userId
	 * @return
	 */
	boolean signOut(String userId);

	/**
	 * 更新新手机号
	 * 
	 * @param userId
	 * @param phone
	 * @return
	 */
	boolean updatePhone(UserBean use, String phone, String vcode);

	/**
	 * 更新头像
	 * 
	 * @param userId
	 * @param icon
	 * @return
	 */
	boolean updateIcon(UserBean use, String icon);

	/**
	 * 更新个人密码
	 * 
	 * @param userId
	 * @param pwd
	 * @param confirmPwd
	 * @return
	 */
	boolean updatePwd(UserBean use, String pwd, String confirmPwd, String checkToken);

	/**
	 * 提交认证信息
	 * 
	 * @param userId
	 * @param name
	 * @param gender
	 * @param idNo
	 * @param idInfo
	 * @return
	 */
	boolean applyAuth(UserBean use, String name, Integer gender, String idNo, String idInfo);

	/**
	 * 获取个人认证信息
	 * 
	 * @param user
	 * @return
	 */
	RUserAuthBean getAuthInfo(UserBean user);

	/**
	 * 验证手机是否验证通过
	 * 
	 * @param phone
	 * @param vcode
	 * @param type
	 * @return
	 */
	RCheckCodeBean checkCode(String phone, String vcode, int type);

	/**
	 * 根据token获取用户信息
	 * 
	 * @param token
	 * @return
	 */
	RUserBean getUserInfoByToken(String userId, String token);

	UserBean getUserById(String uid);

}
