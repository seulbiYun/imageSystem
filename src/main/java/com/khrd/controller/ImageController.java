package com.khrd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.ImageVO;
import com.khrd.domain.PageMaker;
import com.khrd.domain.SearchCriteria;
import com.khrd.service.ImageService;

@RequestMapping("/image/*")
@Controller
public class ImageController {
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	private ImageService service;
	
	@Resource(name = "uploadPath") // bean id값으로 주입(DI:dependency injection)
	private String uploadPath;
	
	@RequestMapping(value = "listAll",method=RequestMethod.GET)
	public void listImage(SearchCriteria scri, Model model) {
		List<ImageVO> list = service.listSearch(scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listSearchCount(scri));
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("scri", scri);
	}
	
}
















