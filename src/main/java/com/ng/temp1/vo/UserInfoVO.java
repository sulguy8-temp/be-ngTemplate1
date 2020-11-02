package com.ng.temp1.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("usi")
@Data
public class UserInfoVO {

	private Integer usiNum;
	private String usiId;
	private String usiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
	private String orders;
	
	private String token;
}