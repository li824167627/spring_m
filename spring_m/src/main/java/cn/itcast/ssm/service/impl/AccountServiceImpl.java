package cn.itcast.ssm.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.northend.util.AppTextUtil;
import com.northend.util.MD5Util;
import com.northend.util.StringUtil;

import cn.itcast.ssm.cache.dao.AccountCacheDao;
import cn.itcast.ssm.cache.dao.CommonCacheDao;
import cn.itcast.ssm.constants.ConfigConstants;
import cn.itcast.ssm.constants.StringConstants;
import cn.itcast.ssm.controller.res.bean.RCheckCodeBean;
import cn.itcast.ssm.controller.res.bean.RUserAuthBean;
import cn.itcast.ssm.controller.res.bean.RUserBean;
import cn.itcast.ssm.model.MessageBean;
import cn.itcast.ssm.model.UserAuthBean;
import cn.itcast.ssm.model.UserAuthLogBean;
import cn.itcast.ssm.model.UserBean;
import cn.itcast.ssm.model.UserLoginLogBean;
import cn.itcast.ssm.model.UserThirdBean;
import cn.itcast.ssm.model.vo.UserAuthVo;
import cn.itcast.ssm.persist.dao.MsgDao;
import cn.itcast.ssm.persist.dao.UserAuthDao;
import cn.itcast.ssm.persist.dao.UserDao;
import cn.itcast.ssm.persist.dao.UserLoginLogDao;
import cn.itcast.ssm.service.AccountService;
import cn.itcast.ssm.service.exception.ServiceException;
import cn.itcast.ssm.util.jpush.JpushUtil;

@Service
public class AccountServiceImpl implements AccountService {
	Logger logger = Logger.getLogger(AccountServiceImpl.class);

	@Autowired
	UserDao userImpl;

	@Autowired
	UserAuthDao userAuthImpl;

	@Autowired
	AccountCacheDao accountCacheImpl;

	@Autowired
	CommonCacheDao commonCacheImpl;

	@Autowired
	UserLoginLogDao userLoginLogImpl;

	@Autowired
	MsgDao msgImpl;

	/**
	 * 用户登录
	 * 
	 * @param phone
	 *            手机号码
	 * @param content
	 * @param type
	 *            登录类型：1手机验证码登录，2用户密码登录
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public RUserBean login(String phone, String password, String vcode, int type, String deviceId, String os,
			String model, int formType, String resolution, int loginPort) throws ServiceException {
		RUserBean result = new RUserBean();
		String cachCode = accountCacheImpl.getVCode(1, phone); // 1 登录
		UserAuthVo user = userImpl.selectOneByPhone(phone);
		if (type == 1) { // 1手机验证码登录
			if (StringUtil.isEmpty(cachCode)) {
				throw new ServiceException("vcode_is_expire");
			}
			if (!cachCode.equals(vcode)) {
				throw new ServiceException("vcode_is_error");
			}
			if (user == null) { // 用户不存在，做注册处理
				user = new UserAuthVo();
				String newId = AppTextUtil.getPrimaryKey();
				user.setId(newId);
				user.setPhone(phone);
				UserBean newuser = new UserBean();
				newuser.setId(newId);
				newuser.setPhone(phone);
				newuser.setPassword("");// 密码默认为空
				newuser.setName("");
				newuser.setLetter("");
				newuser.setIcon("");
				newuser.setGender(1);
				newuser.setIsSetPwd(0);// 是否设置密码 1设置 0未设置
				boolean flag = userImpl.insert(newuser) > 0;
				if (!flag) {
					throw new ServiceException("database_insert_fail", "用户");
				}
			}
		} else {// 账号密码登录
			logger.info(user);
			if (user == null) {// 未注册登录不了
				throw new ServiceException("login_account_password_error");

			}
			if (user.getIsSetPwd() == 0) {
				throw new ServiceException("user_password_not_set");
			}
			if (!user.getPassword().equals(MD5Util.md5(password))) {
				throw new ServiceException("login_account_password_error");
			}
		}

		String token = AppTextUtil.getToken();
		String id = user.getId();
		JSONObject acJson = new JSONObject();
		acJson.put("id", id);
		acJson.put("type", loginPort);
		accountCacheImpl.setToken(token, JSON.toJSONString(acJson), 7 * 24 * 3600);

		UserLoginLogBean logBean = new UserLoginLogBean();
		logBean.setUid(id);
		logBean.setDeviceId(deviceId);
		logBean.setOs(os);
		logBean.setModel(model);
		logBean.setResolution(resolution);
		logBean.setOtype(1);
		logBean.setState(1);
		boolean flag = userLoginLogImpl.insert(logBean) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "用户登录");
		}

		flag = userImpl.updateLoginTime(user) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "用户登录时间");
		}

		if (loginPort == 1) {
			result = parse(user);
		}

		result.setToken(token);

		return result;
	}

	/**
	 * 格式化用户信息
	 * 
	 * @param user
	 * @return
	 */
	private RUserBean parse(UserAuthVo user) {
		RUserBean res = new RUserBean();
		res.setGender(user.getGender());
		res.setIcon(user.getIcon());
		res.setId(user.getId());
		res.setIsSetPwd(user.getIsSetPwd());
		res.setLetter(user.getLetter());
		res.setName(user.getName());
		res.setPhone(user.getPhone());
		if (user.getAuth() != null) {
			res.setUserAuth(paseAuth(user.getAuth()));
			res.setAuthState(user.getAuth().getState());
		} else {
			res.setAuthState(-1);// 未申请
		}
		return res;
	}

	/**
	 * 格式化用户认证信息
	 * 
	 * @param auth
	 * @return
	 */
	private RUserAuthBean paseAuth(UserAuthBean auth) {
		RUserAuthBean res = new RUserAuthBean();
		res.setActionId(auth.getActionId());
		res.setExt(auth.getExt());
		res.setId(auth.getId());
		res.setIdNo(auth.getIdNo());
		res.setName(auth.getName());
		res.setGender(auth.getGender());
		res.setState(auth.getState());
		res.setUserId(auth.getUserId());
		res.setReason(auth.getReason());
		return res;
	}

	/**
	 * 第三方登录
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public RUserBean thirdLogin(String openId, String icon, int type, String deviceId, String os, String model,
			int formType, String resolution, int loginPort) throws ServiceException {
		RUserBean result = new RUserBean();
		UserAuthVo user = userImpl.selectOneByOpenId(openId);
		if (user == null) {
			throw new ServiceException("third_account_not_bind_phone");
		}
		String token = AppTextUtil.getToken();
		String id = user.getId();
		JSONObject acJson = new JSONObject();
		acJson.put("id", id);
		acJson.put("type", loginPort);
		accountCacheImpl.setToken(token, JSON.toJSONString(acJson), 7 * 24 * 3600);

		UserLoginLogBean logBean = new UserLoginLogBean();
		logBean.setUid(id);
		logBean.setDeviceId(deviceId);
		logBean.setOs(os);
		logBean.setModel(model);
		logBean.setResolution(resolution);
		logBean.setOtype(1);
		logBean.setState(1);
		boolean flag = userLoginLogImpl.insert(logBean) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "用户登录");
		}

		flag = userImpl.updateLoginTime(user) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "用户登录时间");
		}
		if (loginPort == 1) {
			result = parse(user);
		}
		result.setToken(token);
		return result;
	}

	/**
	 * 第三方账号绑定手机账号 不存在则新建账号
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public RUserBean thirdBindPhone(int type, String openId, String icon, String phone, String vcode, int loginPort) {
		boolean flag = false;
		RUserBean result = new RUserBean();
		String cacheVcode = accountCacheImpl.getVCode(type, phone);
		if (StringUtil.isEmpty(cacheVcode)) {
			throw new ServiceException("vcode_is_expire");
		}
		if (!vcode.equals(cacheVcode)) {
			throw new ServiceException("vcode_is_error");
		}
		UserAuthVo user = userImpl.selectOneByPhone(phone);
		if (user == null) { // 用户不存在，做注册处理
			user = new UserAuthVo();
			String newId = AppTextUtil.getPrimaryKey();
			user.setId(newId);
			UserBean newuser = new UserBean();
			newuser.setId(newId);
			newuser.setPhone(phone);
			newuser.setPassword("");// 密码默认为空
			newuser.setName("");
			newuser.setLetter("");
			newuser.setIcon(icon);
			newuser.setGender(1);
			newuser.setIsSetPwd(0);// 是否设置密码 1设置 0未设置
			flag = userImpl.insert(newuser) > 0;
			if (!flag) {
				throw new ServiceException("database_insert_fail", "用户");
			}
		}

		UserThirdBean third = new UserThirdBean();
		third.setOpenId(openId);
		third.setType(type);
		third.setUserId(user.getId());
		third.setType(type);
		flag = userImpl.insertThird(third) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "第三方登录账号");
		}
		String token = AppTextUtil.getToken();
		UserAuthVo callback = userImpl.selectOneByPhone(phone);
		JSONObject acJson = new JSONObject();
		acJson.put("id", callback.getId());
		acJson.put("type", loginPort);
		accountCacheImpl.setToken(token, JSON.toJSONString(acJson), 7 * 24 * 3600);

		UserLoginLogBean logBean = new UserLoginLogBean();
		logBean.setUid(callback.getId());
		logBean.setOtype(1);
		logBean.setState(1);
		flag = userLoginLogImpl.insert(logBean) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "用户登录");
		}

		flag = userImpl.updateLoginTime(user) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "用户登录时间");
		}
		if (loginPort == 1) {
			result = parse(user);
		}
		result.setToken(token);
		return result;
	}

	/**
	 * 更新手机号
	 */
	@Override
	public boolean updatePhone(UserBean user, String phone, String vcode) {
		boolean flag = false;

		String cacheVcode = accountCacheImpl.getVCode(4, phone);
		if (StringUtil.isEmpty(cacheVcode)) {
			throw new ServiceException("vcode_is_expire");
		}
		if (!vcode.equals(cacheVcode)) {
			throw new ServiceException("vcode_is_error");
		}

		UserAuthVo phoneUser = userImpl.selectOneByPhone(phone);
		if (phoneUser != null) {
			throw new ServiceException("object_is_exist", "手机账号");
		}
		UserBean updateUser = new UserBean();
		updateUser.setId(user.getId());
		updateUser.setPhone(phone);
		flag = userImpl.update(updateUser) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "手机号");
		}
		return flag;
	}

	/**
	 * 更新头像
	 */
	@Override
	public boolean updateIcon(UserBean user, String icon) {
		UserBean updateUser = new UserBean();
		updateUser.setId(user.getId());
		updateUser.setIcon(icon);
		boolean flag = userImpl.update(updateUser) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "手机号");
		}
		return flag;
	}

	@Override
	public boolean updatePwd(UserBean user, String pwd, String confirmPwd, String checkToken) {
		boolean flag = false;
		String cacheUid = accountCacheImpl.getPhoneByCheckToken(1, checkToken);
		if (cacheUid == null) {
			throw new ServiceException("checktoken_is_expire");
		}

		if (!cacheUid.equals(user.getId())) {
			throw new ServiceException("checktoken_is_error");
		}

		UserBean updateUser = new UserBean();
		updateUser.setId(user.getId());

		if (StringUtil.isEmpty(pwd) || !pwd.equals(confirmPwd)) {
			throw new ServiceException("user_pwd_confirmpwd_not_equals");
		}

		updateUser.setPassword(MD5Util.md5(pwd));
		updateUser.setIsSetPwd(1);
		flag = userImpl.update(updateUser) > 0;
		if (!flag) {
			throw new ServiceException("database_update_fail", "手机号");
		}
		return flag;
	}

	/**
	 * 提交认证信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean applyAuth(UserBean user, String name, Integer gender, String idNo, String idInfo) {
		boolean flag = false;
		UserAuthBean auth = userAuthImpl.selectAuthByUid(user.getId());
		if (auth != null) {// 不为空则更新
			auth.setExt(idInfo);
			auth.setIdNo(idNo);
			auth.setState(0);//
			auth.setName(name);
			auth.setGender(gender);
			flag = userAuthImpl.update(auth) > 0;
			if (!flag) {
				throw new ServiceException("database_update_fail", "用户认证信息");
			}
		} else { // 为空则插入
			auth = new UserAuthBean();
			auth.setIdNo(idNo);
			auth.setExt(idInfo);
			auth.setName(name);
			auth.setGender(gender);
			auth.setState(0);
			auth.setUserId(user.getId());
			flag = userAuthImpl.insert(auth) > 0;
			if (!flag) {
				throw new ServiceException("database_insert_fail", "用户认证信息");
			}

		}
		// 更新用户信息 ?
		// UserBean updateUser = new UserBean();
		// updateUser.setGender(gender);
		// updateUser.setName(name);
		// flag = userImpl.update(updateUser) > 0;
		// if(!flag) {
		// throw new ServiceException("database_update_fail", "用户信息");
		// }
		// 插入日志表
		UserAuthLogBean authLog = new UserAuthLogBean();
		authLog.setIdNo(idNo);
		authLog.setExt(idInfo);
		authLog.setName(name);
		authLog.setGender(gender);
		authLog.setState(0);
		authLog.setUserId(user.getId());
		flag = userAuthImpl.insertAuthLog(authLog) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "管理员账号");
		}

		// 通知
		Map<String, String> extras = new HashMap<>();
		extras.put("type", "1");
		extras.put("userId", user.getId());
		extras.put("name", user.getName());
		extras.put("state", "0");

		Set<String> alias = new HashSet<>();
		alias.add(user.getId());
		String title = StringConstants.getInstance().getString("user_auth_title");
		String content = StringConstants.getInstance().getString("user_wait_auth");

		MessageBean msg = new MessageBean();
		msg.setTitle(title);
		msg.setContent("【" + ConfigConstants.getInstance().getAliSignName() + "】" + content);
		msg.setExtras(JSON.toJSONString(extras));
		msg.setType(1);
		msg.setTuid(user.getId());
		msg.setCode(101);
		msg.setLoginPort(1);
		flag = msgImpl.insert(msg) > 0;
		if (!flag) {
			throw new ServiceException("database_insert_fail", "认证消息");
		}
		extras.put("msgId", msg.getMid() + "");
		JpushUtil.init(ConfigConstants.getInstance().getJpushAppKey(), ConfigConstants.getInstance().getJpushSecret());

		JpushUtil.sendPushNotificationByAlias(alias, content, title, extras);

		return flag;
	}

	/**
	 * 获取用户认证信息
	 */
	@Override
	public RUserAuthBean getAuthInfo(UserBean user) {
		RUserAuthBean res = new RUserAuthBean();
		UserAuthBean auth = userAuthImpl.selectAuthByUid(user.getId());
		if (auth == null) {
			res = new RUserAuthBean();
			res.setState(-1);
			return res;
		}
		res = paseAuth(auth);
		return res;
	}

	/**
	 * 登出
	 */
	@Override
	public boolean signOut(String userId) {
		return accountCacheImpl.clearTokenAndUid(userId);
	}

	/**
	 * 根据token 获取用户信息
	 */
	@Override
	public UserBean getUserById(String uid) {
		if (!StringUtil.isEmpty(uid)) {
			UserBean user = userImpl.selectOneByUid(uid);
			return user;
		}
		return null;
	}

	@Override
	public RCheckCodeBean checkCode(String phone, String vcode, int type) {
		RCheckCodeBean checkToken = new RCheckCodeBean();
		int checkType = type == 1 ? 2 : type == 2 ? 4 : 0;
		String cacheVcode = accountCacheImpl.getVCode(checkType, phone);
		if (StringUtil.isEmpty(cacheVcode)) {
			throw new ServiceException("vcode_is_expire");
		}
		if (!vcode.equals(cacheVcode)) {
			throw new ServiceException("vcode_is_error");
		}
		String token = AppTextUtil.getToken();
		checkToken.setCheckToken(token);
		// 1修改密码，2更新手机号
		if (type == 1) { // 获取当前手机用户信息
			UserAuthVo user = userImpl.selectOneByPhone(phone);
			if (user == null) {
				throw new ServiceException("object_is_not_exist", "手机账号");
			}
			accountCacheImpl.setCheckPhoneToken(type, user.getId(), token);
		} else {
			UserAuthVo user = userImpl.selectOneByPhone(phone);
			if (user != null) {
				throw new ServiceException("object_is_exist", "手机绑定账号");
			}
			accountCacheImpl.setCheckPhoneToken(type, phone, token);
		}
		return checkToken;
	}

	@Override
	public RUserBean getUserInfoByToken(String uid, String token) {
		RUserBean result = new RUserBean();
		if (StringUtil.isEmpty(uid)) {
			return null;
		}
		UserAuthVo user = userImpl.selectAuthVoByUid(uid);
		result = parse(user);
		result.setToken(token);
		return result;
	}

}
