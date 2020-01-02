package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.Criteria;
import com.khrd.domain.ImageVO;
import com.khrd.domain.SearchCriteria;
@Repository
public class ImageDAOImpl implements ImageDAO {

	private final static String namespace = "mappers.ImageMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ImageVO> listAll() {
		return sqlSession.selectList(namespace+".listAll");
	}
	
	@Override
	public List<ImageVO> imageList(int page, int perPage) {
		page = (page-1) * perPage;
		
		Map<String , Integer> map = new HashMap<String, Integer>();
		map.put("page",page);
		map.put("perPage",perPage);
		
		return sqlSession.selectList(namespace+".imageList", map);
	}

	@Override
	public ImageVO readByIno(int ino) {
		return sqlSession.selectOne(namespace+".readByIno", ino);
	}

	@Override
	public List<ImageVO> listCri(Criteria cri) {
		return null;
	}

	@Override
	public int listCount() {
		return sqlSession.selectOne(namespace+".listCount");
	}

	@Override
	public List<ImageVO> listSearch(SearchCriteria scri) {
		return sqlSession.selectList(namespace+".listSearch", scri);
	}

	@Override
	public int listSearchCount(SearchCriteria scri) {
		return sqlSession.selectOne(namespace+".listSearchCount", scri);
	}
	
	@Override
	public void imageRegist(ImageVO vo) {
		sqlSession.insert(namespace+".imageRegist", vo);
	}

	

	

}
