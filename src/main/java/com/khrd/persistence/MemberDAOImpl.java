package com.khrd.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private final static String namespace = "mappers.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO selectByIdAndPass(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".selectByIdAndPass", vo);
	}
	
	@Override
	public void regist(MemberVO vo) {
		sqlSession.insert(namespace + ".regist", vo);
	}

	@Override
	public MemberVO useridChek(String userid) {
		return sqlSession.selectOne(namespace + ".useridChek", userid);
	}

}
