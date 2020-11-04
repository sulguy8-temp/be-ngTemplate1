package com.ng.temp1.types;

public enum ErrorType {
	ERR01("??"),
	ERR02("이미 가입되어 있는 이메일 입니다."),
	ERR03("로그인이 만료되었습니다.");

	private final String errText; 
	
	private ErrorType(String str) {
		this.errText = str;
	}
    public String getErrorText() {
        return this.errText;
     }
}
