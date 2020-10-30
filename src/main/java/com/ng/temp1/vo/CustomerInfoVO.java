package com.ng.temp1.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import com.ng.temp1.validator.ValidImage;

import lombok.Data;

@Alias("cui")
@Data
public class CustomerInfoVO {

	// 추후제거
	private String cuiId;
	
	private Integer cuiNum;
	private String cuiName;
	private String cuiNickname;
	private String cuiMobilePhone;
	private String cuiHomePhone;
	private String cuiTrans;
	private String cuiBirth;
	private String cuiProfileimgName;
	@ValidImage
	private MultipartFile cuiProfileimg;
	private String cuiAgreeLocation;
	private String cuiAgreeLocationdat;
	private String cuiAgreePhone;
	private String cuiAgreePhonedat;
	private String cuiAgreeCamera;
	private String cuiAgreeCameradat;
	private String cuiAgreePush;
	private String cuiAgreePushdat;
	private String cuiAgreeSms;
	private String cuiAgreeSmsdat;
	private String cuiAgreeEmail;
	private String cuiAgreeEmaildat;
	private String cuiAgreeService;
	private String cuiAgreeServicedat;
	private String cuiAgreePrivate;
	private String cuiAgreePrivatedat;
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