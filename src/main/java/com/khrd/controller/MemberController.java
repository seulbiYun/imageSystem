package com.khrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khrd.domain.MemberVO;
import com.khrd.service.MemberService;

@RequestMapping("/member/*")
@RestController
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "mList",method = RequestMethod.GET)
	public ResponseEntity<List<MemberVO>> memberList(){
		ResponseEntity<List<MemberVO>> entity = null;
		
		try {
			List<MemberVO> list = service.memberList();
			
			entity = new ResponseEntity<List<MemberVO>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<MemberVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return  entity;
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<String> registPost(@RequestBody MemberVO vo){
		ResponseEntity<String> entity = null;
		logger.info("---------------------regist POST--------------------");
		
		try {
			service.regist(vo);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
}
