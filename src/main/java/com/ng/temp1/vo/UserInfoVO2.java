package com.ng.temp1.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("usi2")
@Data
public class UserInfoVO2 {

	private Integer usiNum;
	private String usiId;
	private String usiPwd;
}