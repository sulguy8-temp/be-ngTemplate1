package com.ng.temp1.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.github.pagehelper.Page;
import com.ng.temp1.vo.UserInfoVO;
import com.ng.temp1.vo.UserInfoVO2;

@MapperScan
public interface UserInfoMapper {
	UserInfoVO2 test(int usiNum);
	
	Page<UserInfoVO> selectUSIList(UserInfoVO usi);
	UserInfoVO selectUSI(int usiNum);
	int updateUSI(UserInfoVO usi);
	int insertUSI(UserInfoVO usi);
	int deleteUSI(int usiNum);
}