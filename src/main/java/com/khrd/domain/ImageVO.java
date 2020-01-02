package com.khrd.domain;

import java.sql.Date;

public class ImageVO {
	private int ino;
	private String fullname;
	private Date uploaddate;
	private MemberVO userid;

	public ImageVO() {
		super();
	}

	public ImageVO(int ino, String fullname, Date uploaddate, MemberVO userid) {
		super();
		this.ino = ino;
		this.fullname = fullname;
		this.uploaddate = uploaddate;
		this.userid = userid;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public MemberVO getMember() {
		return userid;
	}

	public void setMember(MemberVO userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ImageVO [ino=" + ino + ", fullname=" + fullname + ", uploaddate=" + uploaddate + ", userid=" + userid
				+ "]";
	}

}
