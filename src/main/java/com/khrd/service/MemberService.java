package com.khrd.service;

import java.util.List;

import com.khrd.domain.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public MemberVO memberListByUserId(String userid);
	public MemberVO selectByIdAndPass(MemberVO vo);
	public void regist(MemberVO vo);
	public  void modify(MemberVO vo);
	public void remove(String userid);
}
