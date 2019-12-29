package com.khrd.controller;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upload/*")
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name = "uploadPath")//id로 주입을 받음(DI : dependency Injection)을 받음
	private String uploadPath;
	
	@RequestMapping(value = "displayFile",method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		
		logger.info("filename : "+filename);
		
		try {//확장자
			String formatName = filename.substring(filename.lastIndexOf(".")+1);
			MediaType type = null;
			if(formatName.equalsIgnoreCase("jpg")) {
				type = MediaType.IMAGE_JPEG;
			}else if (formatName.equalsIgnoreCase("png")) {
				type = MediaType.IMAGE_PNG;
			}else if (formatName.equalsIgnoreCase("gif")) {
				type = MediaType.IMAGE_GIF;
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);
			InputStream in = new FileInputStream(uploadPath + "/"+filename);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
}
