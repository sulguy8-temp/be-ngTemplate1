package com.ng.temp1.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("usi")
@Data
public class UserInfoVO {

	private Integer usiNum;
	private String usiId;
	@NotNull
	private Integer cuiNum;
	@NotNull
	private Integer maiNum;
	@NotNull
	private Integer shiNum;
	private String usiPwd;
	private String lastLogin;
	private String lastChangePwddat;
	private String credat;
	private String cretim;
	@NotNull
	private Integer creusr;
	private String moddat;
	private String modtim;
	@NotNull
	private Integer modusr;
	@NotNull
	private String active;
	private String orders;
}