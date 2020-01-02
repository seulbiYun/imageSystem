package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.Criteria;
import com.khrd.domain.ImageVO;
import com.khrd.domain.SearchCriteria;
import com.khrd.persistence.ImageDAO;

@Repository
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageDAO dao;
	
	@Override
	public List<ImageVO> listAll() {
		return dao.listAll();
	}

	@Override
	public ImageVO readByIno(int ino) {
		return dao.readByIno(ino);
	}

	@Override
	public List<ImageVO> listCri(Criteria cri) {
		return dao.listCri(cri);
	}

	@Override
	public int listCount() {
		return dao.listCount();
	}

	@Override
	public List<ImageVO> listSearch(SearchCriteria scri) {
		return dao.listSearch(scri);
	}

	@Override
	public int listSearchCount(SearchCriteria scri) {
		return dao.listSearchCount(scri);
	}
		
	@Override
	public void imageRegist(ImageVO vo) {
		dao.imageRegist(vo);
	}

	

}
