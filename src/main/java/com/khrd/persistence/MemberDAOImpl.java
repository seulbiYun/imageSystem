package com.khrd.persistence;

import java.util.List;

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
	public List<MemberVO> memberList() {
		return sqlSession.selectList(namespace+".memberList");
	}

	@Override
	public MemberVO memberListByUserId(String userid) {
		return sqlSession.selectOne(namespace + "memberListByUserId", userid);
	}

	@Override
	public MemberVO selectByIdAndPass(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".selectByIdAndPass", vo);
	}
	
	@Override
	public void regist(MemberVO vo) {
		sqlSession.insert(namespace + ".regist", vo);
	}

	@Override
	public void modify(MemberVO vo) {
		sqlSession.update(namespace + ".modify", vo);
	}

	@Override
	public void remove(String userid) {
		sqlSession.delete(namespace + ".remove", userid);
	}

}
