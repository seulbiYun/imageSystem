package com.khrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khrd.domain.MemberVO;
import com.khrd.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
			
	// 회원가입 ==================================================
	@RequestMapping(value = "regist",method = RequestMethod.GET)
	public void registGet(Model model){
		logger.info("---------------------regist GET--------------------");
		MemberVO dbVO = new MemberVO();
		model.addAttribute("dbID", dbVO.getUserid());
	}
	
	@RequestMapping(value = "regist",method = RequestMethod.POST)
	public String registPost(MemberVO vo){
		logger.info("---------------------regist POST--------------------");
		
		service.regist(vo);
		
		return "redirect:/auth/login";
	}
	
	// 아이디 중복 확인 ==================================================
	@ResponseBody // ajax용 함수
	@RequestMapping(value = "chek",method = RequestMethod.GET)
	public ResponseEntity<String> useridChek(String userid){
		logger.info("---------------------userId Chek--------------------"+userid);
		ResponseEntity<String> entity = null;
		
		try {
			MemberVO dbVO = service.useridChek(userid);
			System.out.println(dbVO);
			if(dbVO == null) {
				entity = new ResponseEntity<String>("success",HttpStatus.OK);
			}else if(dbVO != null){
				entity = new ResponseEntity<String>("fail",HttpStatus.OK);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
