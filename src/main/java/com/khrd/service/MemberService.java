package com.khrd.service;

import com.khrd.domain.MemberVO;

public interface MemberService {	
	public MemberVO selectByIdAndPass(MemberVO vo);
	public void regist(MemberVO vo);
	public MemberVO useridChek(String userid);
}
