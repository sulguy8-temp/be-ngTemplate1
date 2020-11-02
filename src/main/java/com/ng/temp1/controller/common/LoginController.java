package com.ng.temp1.controller.common;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ng.temp1.service.common.LoginService;
import com.ng.temp1.vo.UserInfoVO;

@Controller
public class LoginController {
	
	@Resource 
	private LoginService loginService;
	
	@PostMapping("/login/user")
	public @ResponseBody Map<String,Object> doUserLogin(@RequestBody UserInfoVO usi){
		return loginService.doUserLogin(usi);
	}
}
