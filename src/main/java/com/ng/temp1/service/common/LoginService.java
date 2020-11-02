package com.ng.temp1.service.common;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ng.temp1.exception.ServiceException;
import com.ng.temp1.mapper.common.LoginMapper;
import com.ng.temp1.utils.JWTUtil;
import com.ng.temp1.utils.SHAE;
import com.ng.temp1.vo.UserInfoVO;

@Service
public class LoginService {

	@Resource
	private LoginMapper loginMapper;

	public Map<String,Object> doUserLogin(UserInfoVO usi){
		if(usi.getUsiPwd()==null || usi.getUsiPwd().isEmpty()) {
			throw new ServiceException("비밀번호를 확인해주세요.");
		}
		usi.setUsiPwd(SHAE.encodeSHA(usi.getUsiPwd()));
		Map<String,Object> rMap = new HashMap<>();
		usi = loginMapper.selectForCUI(usi);
		if(usi==null) {
			throw new ServiceException("아이디나 비밀번호가 잘못되었습니다.");
		}

		usi.setToken(JWTUtil.generateJWT(usi));
		usi.setUsiPwd("");
		rMap.put("user", usi);
		return rMap;
	}
}
