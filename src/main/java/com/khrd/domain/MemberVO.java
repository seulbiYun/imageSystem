package com.khrd.domain;

public class MemberVO {
	private String userid;
	private String userpw;
	private String pwok;
	private String usernm;
	private String email;
	private String tel;

	public MemberVO() {
		super();
	}

	public MemberVO(String userid, String userpw, String pwok, String usernm, String email, String tel) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.pwok = pwok;
		this.usernm = usernm;
		this.email = email;
		this.tel = tel;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getPwok() {
		return pwok;
	}

	public void setPwok(String pwok) {
		this.pwok = pwok;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", pwok=" + pwok + ", usernm=" + usernm
				+ ", email=" + email + ", tel=" + tel + "]";
	}

}
