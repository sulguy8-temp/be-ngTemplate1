package com.ng.temp1.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ng.temp1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTUtil {
	
	private static String SALT = "shoping";
	private static Map<String,Date> getDateMap() {
		Map<String,Date> dateMap = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		Date issueDate = calendar.getTime();		
		calendar.add(Calendar.DATE, 1);
		Date expireDate = calendar.getTime();
		dateMap.put("issueDate", issueDate);
		dateMap.put("expireDate", expireDate);
		return dateMap;
	}
	
	public static String generateJWT(UserInfoVO usi) {		
		return generateJWT(usi.getUsiId());
	}
	public static String generateJWT(String id) {
		Map<String,Date> dateMap = getDateMap();
		return JWT.create()
				.withIssuer(id)
				.withIssuedAt(dateMap.get("issueDate"))
				.withExpiresAt(dateMap.get("expireDate"))
				.sign(Algorithm.HMAC256(SALT)).toString();
	}
	public static String generateJWTF(String jwtf) {
		 String jwt = JWT.create()
				.withIssuer(jwtf)
				.sign(Algorithm.HMAC256(SALT));
		log.info("jwtf=>{}",jwt);		
		return jwt;
	}
	public static void verifiJWT(String token, UserInfoVO usi) {
		JWTVerifier verifier = JWT
				.require(Algorithm.HMAC256(SALT))
				.withIssuer(usi.getUsiId())
				.build();
		verifier.verify(token);
	}
	public static void verifiJWT(String token, String id) {
		log.info("token=>{}", token); 
		JWTVerifier verifier = JWT
				.require(Algorithm.HMAC256(SALT))
				.withIssuer(id)
				.build();
		verifier.verify(token);
	}
}
