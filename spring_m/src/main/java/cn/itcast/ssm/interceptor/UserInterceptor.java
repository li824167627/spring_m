package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.itcast.ssm.cache.dao.AccountCacheDao;
import cn.itcast.ssm.constants.Rescode;
import cn.itcast.ssm.constants.RescodeConstants;
import cn.itcast.ssm.controller.res.BaseResult;
import cn.itcast.ssm.model.UserBean;
import cn.itcast.ssm.service.AccountService;
import com.northend.util.NumUtil;
import com.northend.util.StringUtil;

public class UserInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	AccountService accountServiceImpl;

	@Autowired
	AccountCacheDao accountCacheImpl;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		String token = request.getHeader("token");
		logger.info("request header token is:" + token);
		if (StringUtil.isEmpty(token)) {
			token = request.getParameter("token");
			logger.info("request parameter token is:" + token);
		}
		if (!StringUtil.isEmpty(token)) {
			String uidJson = accountCacheImpl.getUidByToken(token, 604800l); // 往后延迟7天
			logger.info("uidJson parameter token is:" + uidJson);
			if (!StringUtil.isEmpty(uidJson)) {
				JSONObject uobj = JSON.parseObject(uidJson);
				String uid = uobj.getString("id");
				int type = NumUtil.toInt(uobj.get("type"), 1);
				if (!StringUtil.isEmpty(uid)) {
					request.setAttribute("userId", uid);
					logger.info("userId is :" + uid);
					if (type == 1) {
						UserBean user = accountServiceImpl.getUserById(uid);
						request.setAttribute("user", user);
					}
					flag = true;
				}
			}

		} else {
			String uid = "63916ae97fc74851add2889cdb0a7508";
			request.setAttribute("userId", uid);
			logger.info("test userId is :" + uid);
			flag = true;
		}
		if (!flag) {
			BaseResult result = new BaseResult();

			Rescode rescode = RescodeConstants.getInstance().get("token_fail");
			result.setFlag(false);
			result.setRescode(rescode.getCode());
			result.setMsg(rescode.getMsg());
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
