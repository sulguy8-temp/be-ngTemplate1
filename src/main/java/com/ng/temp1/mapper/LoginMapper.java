package com.ng.temp1.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.ng.temp1.vo.UserInfoVO;

@MapperScan
public interface LoginMapper {
	UserInfoVO selectForCUI(UserInfoVO usi);
	int updateLastLogin(UserInfoVO usi);
}
