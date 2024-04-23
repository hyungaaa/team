package com.spring.Mng;

import java.util.Date;

public class MypageDTO {
	private String unum;
	private String uname;
	private String uuid;
	private String uposition;
	private String ccode;
	private Date ubirth;
	private String utel;
	private String uemail;
	private Date udate;

	public String getUnum() {
		return unum;
	}

	public void setUnum(String unum) {
		this.unum = unum;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUposition() {
		return uposition;
	}

	public void setUposition(String uposition) {
		this.uposition = uposition;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Date getUbirth() {
		return ubirth;
	}

	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	@Override
	public String toString() {
		return "MypageDTO [unum=" + unum + ", uname=" + uname + ", uuid=" + uuid + ", uposition=" + uposition
				+ ", ccode=" + ccode + ", ubirth=" + ubirth + ", utel=" + utel + ", uemail=" + uemail + ", udate="
				+ udate + "]";
	}

}
