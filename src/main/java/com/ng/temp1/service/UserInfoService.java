package com.ng.temp1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ng.temp1.exception.ServiceException;
import com.ng.temp1.mapper.UserInfoMapper;
import com.ng.temp1.utils.FileUtils;
import com.ng.temp1.vo.UserInfoVO;
import com.ng.temp1.vo.common.PaginationVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInfoService {

	@Resource
	private UserInfoMapper usiMapper;
	
	@Resource
	private FileUtils fu;
	
	private String path = "usi";
	
	public Page<UserInfoVO> selectUSIList(UserInfoVO usi,PaginationVO page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		System.out.println(usiMapper.selectUSIList(usi));
		return usiMapper.selectUSIList(usi);
	}
	
	public List<UserInfoVO> selectUSIList() {
		return usiMapper.selectUSIList(null);
	}
	
	public UserInfoVO selectUSI(int usi_num) {
		return usiMapper.selectUSI(usi_num);
	}
		
	public Map<String,Object> updateUSI(UserInfoVO usi) {
		Map<String,Object> rMap = new HashMap<>();
		if(!fu.autoSaveFile(usi, path)) {
			throw new ServiceException("파일 등록 중 문제가 발생하였습니다. 다시 시도해주시기 바랍니다.");
		}
		int rCnt = usiMapper.updateUSI(usi);
		if(rCnt!=1) {
			throw new ServiceException("디비 등록 중 문제가 발생하였습니다. 다시 시도해주시기 바랍니다.");
		}
		rMap.put("cnt", rCnt);
		rMap.put("result","ok");
		return rMap;
	}
	
	public Map<String,Object> insertUSI(UserInfoVO usi) {
		Map<String,Object> rMap = new HashMap<>();
		if(!fu.autoSaveFile(usi, path)) {
			throw new ServiceException("파일 등록 중 문제가 발생하였습니다. 다시 시도해주시기 바랍니다.");
		}
		int rCnt = usiMapper.insertUSI(usi);
		if(rCnt!=1) {
			throw new ServiceException("DB 등록 중 문제가 발생하였습니다. 다시 시도해주시기 바랍니다.");
		}
		rMap.put("cnt", rCnt);
		rMap.put("result","ok");
		return rMap;
	}
	public Map<String,Object> deleteUSI(List<Integer> nums) {
		Map<String,Object> rMap = new HashMap<>();
		int rCnt = 0;
		for(int num : nums) {
			rCnt += usiMapper.deleteUSI(num);
		}
		if(rCnt!=nums.size()) {
			throw new ServiceException("삭제 중 문제가 발생하였습니다. 다시 시도해주시기 바랍니다.");
		}
		rMap.put("cnt", rCnt);
		rMap.put("result","ok");
		return rMap;
	}
}