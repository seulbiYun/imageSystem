package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.MemberVO;
import com.khrd.persistence.MemberDAO;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO memberListByUserId(String userid) {
		return dao.memberListByUserId(userid);
	}
	
	@Override
	public MemberVO selectByIdAndPass(MemberVO vo) {
		return dao.selectByIdAndPass(vo);
	}

	@Override
	public void regist(MemberVO vo) {
		dao.regist(vo);
	}
	
	@Override
	public void modify(MemberVO vo) {
		dao.modify(vo);
	}

	@Override
	public void remove(String userid) {
		dao.remove(userid);
	}

}
