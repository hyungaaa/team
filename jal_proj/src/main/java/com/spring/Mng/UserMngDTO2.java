package com.spring.Mng;

public class UserMngDTO2 {

	private String rcategory;
	private String unum;
	private String uuid;
	private String uemail;
	private String upass;

	public String getUnum() {
		return unum;
	}

	public void setUnum(String unum) {
		this.unum = unum;
	}

	public String getRcategory() {
		return rcategory;
	}

	public void setRcategory(String rcategory) {
		this.rcategory = rcategory;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	@Override
	public String toString() {
		return "UserMngDTO2 [unum=" + unum + ", rcategory=" + rcategory + ", uemail=" + uemail + ", uuid=" + uuid + "]";
	}

}
