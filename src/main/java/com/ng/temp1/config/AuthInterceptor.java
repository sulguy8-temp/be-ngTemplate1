package com.ng.temp1.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ng.temp1.exception.ServiceException;
import com.ng.temp1.exception.TokenException;
import com.ng.temp1.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		log.debug("admin session check before");
		String angular = request.getHeader("x-angular");
		String id = request.getHeader("x-auth-id");
		String token = request.getHeader("x-auth-token");
		String mobileAgent = request.getHeader("x-auth-mobile-agent");
		String method = request.getMethod();
		String uri = request.getRequestURI();

		log.info("uri=>{}",uri);
		log.info("method=>{}",method);
		if(method.contentEquals("OPTIONS")) {
			return true;
		}

		if(angular!=null) {
			if(id==null || token==null || method==null) {
				return false;
			}
			try {
				JWTUtil.verifiJWT(token, id);
			}catch(Exception e){
				if(!"".equals(id) && !"guest".equals(id)) {
					log.error(e.getMessage());
					throw new TokenException("세션이 만료되었습니다. \r\n다시 로그인 해주세요.",id);
				}
			}			
			return true;
		}

		log.info("admin=>{}","0:0:0:0:0:0:0:1".equals(request.getRemoteAddr()));
		log.info("request.getRequestURI()=>{}",request.getRequestURI());
		if("0:0:0:0:0:0:0:1".equals(request.getRemoteAddr())) {
			return true;
		}
		
//		if("/".equals(request.getRequestURI()) || request.getRequestURI().indexOf("/gen")==0) {
//			response.sendRedirect(request.getContextPath() + "/adm/login");
//		}else {
//			throw new ServiceException("로그인이 만료되었습니다.","err03");
//		} 
		return false; 
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.debug("admin session check pass");
		super.postHandle(request, response, handler, modelAndView);
	}
}
