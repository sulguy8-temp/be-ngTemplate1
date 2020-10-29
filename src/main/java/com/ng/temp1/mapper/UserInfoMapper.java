package com.ng.temp1.mapper;

import org.mybatis.spring.annotation.MapperScan;
import com.github.pagehelper.Page;
import com.ng.temp1.vo.UserInfoVO;

@MapperScan
public interface UserInfoMapper {
	Page<UserInfoVO> selectUSIList(UserInfoVO usi);
	UserInfoVO selectUSI(int usiNum);
	int updateUSI(UserInfoVO usi);
	int insertUSI(UserInfoVO usi);
	int deleteUSI(int usiNum);
}