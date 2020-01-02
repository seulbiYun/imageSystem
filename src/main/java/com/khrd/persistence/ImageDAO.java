package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.Criteria;
import com.khrd.domain.ImageVO;
import com.khrd.domain.SearchCriteria;

public interface ImageDAO {
	public List<ImageVO> listAll();
	public List<ImageVO> imageList(int page,int perPage);
	public ImageVO readByIno(int ino);
	public List<ImageVO> listCri(Criteria cri);
	public int listCount();
	public List<ImageVO> listSearch(SearchCriteria scri);
	public int listSearchCount(SearchCriteria scri);
	public void imageRegist(ImageVO vo);
	
}
