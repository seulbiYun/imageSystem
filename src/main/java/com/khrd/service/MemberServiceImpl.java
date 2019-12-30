package com.khrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.MemberVO;
import com.khrd.persistence.MemberDAO;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberVO selectByIdAndPass(MemberVO vo) {
		return dao.selectByIdAndPass(vo);
	}

	@Override
	public void regist(MemberVO vo) {
		dao.regist(vo);
	}

	@Override
	public MemberVO useridChek(String userid) {
		return dao.useridChek(userid);
	}

}
