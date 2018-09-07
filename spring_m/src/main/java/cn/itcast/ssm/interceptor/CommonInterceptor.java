package cn.itcast.ssm.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	private long startTime;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Logger.getLogger(this.getClass()).info("start----------------------------------------------");

		request.setCharacterEncoding("utf-8");

		startTime = System.currentTimeMillis();
		Logger.getLogger(this.getClass()).info("请求Req-Url: " + request.getRequestURL().toString());
		Logger.getLogger(this.getClass()).info("http method: " + request.getMethod());
		Logger.getLogger(this.getClass()).info("http remoteAddr: " + request.getRemoteAddr());

		StringBuffer headersb = new StringBuffer();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			headersb.append(headerName + " " + headerValue + "\n");
		}
		Logger.getLogger(this.getClass()).info("header:\n" + headersb.toString());

		// 输出参数
		StringBuffer sb = new StringBuffer("");
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] vs = map.get(key);
			String value = "";
			for (String s : vs) {
				value += s;
			}
			sb.append("&" + key + "=" + value);
		}
		Logger.getLogger(this.getClass()).info("请求的参数：" + sb.toString());

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Logger.getLogger(this.getClass()).info("执行时间：" + (System.currentTimeMillis() - startTime) + "ms");
		Logger.getLogger(this.getClass()).info("end----------------------------------------------");
		super.afterCompletion(request, response, handler, ex);
	}
}