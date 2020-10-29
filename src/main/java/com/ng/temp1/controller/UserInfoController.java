package com.ng.temp1.controller;

import java.io.Closeable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ng.temp1.mapper.UserInfoMapper;
import com.ng.temp1.service.UserInfoService;
import com.ng.temp1.vo.PaginationVO;
import com.ng.temp1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserInfoController {

	@Resource
	private UserInfoService usiService;
	
	@Resource
	private UserInfoMapper usiMapper;

	@GetMapping("/test")
	public  void test(){	
		System.out.println("test");
		System.out.println(usiMapper.test(1));
	}
	
	@GetMapping("/user/usis")
	public  Closeable selectUSIList(UserInfoVO usi, PaginationVO page){
		return usiService.selectUSIList(usi, page);
	}
	@GetMapping("/user/usi/{usiNum}")
	public  UserInfoVO selectUSI(@PathVariable("usiNum") int usiNum){
		return usiService.selectUSI(usiNum);
	}
	@PostMapping("/user/usi")
	public  Map<String,Object> insertUSI(@ModelAttribute  UserInfoVO usi) {
		return usiService.insertUSI(usi);
	}
	@PostMapping("/user/usi/mod")
	public Map<String,Object> updateUSI(@ModelAttribute UserInfoVO usi) {
		return usiService.updateUSI(usi);
	}
	@PostMapping("/user/usis/del")
	public Map<String,Object> deleteUSI(@RequestBody List<Integer> nums) {
		return usiService.deleteUSI(nums);
	}
}
