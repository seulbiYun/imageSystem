package com.khrd.persistence;

import com.khrd.domain.MemberVO;

public interface MemberDAO {
	public void regist(MemberVO vo);
	public MemberVO selectByIdAndPass(MemberVO vo);
	public MemberVO useridChek(String userid);
}
