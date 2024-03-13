package Mng;

import java.sql.Date;

public class UserMngDTO {
	// user_info table fields
	private String uname;
	private String unum;
	private String uposition;

	// center_list table fields
	private String cname;

	// user_power table fields
	private String updv;
	private String updior;
	private String updr;
	private String updiom;
	private String ubdm;
	private String uum;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUnum() {
		return unum;
	}

	public void setUnum(String unum) {
		this.unum = unum;
	}

	public String getUposition() {
		return uposition;
	}

	public void setUposition(String uposition) {
		this.uposition = uposition;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUpdv() {
		return updv;
	}

	public void setUpdv(String updv) {
		this.updv = updv;
	}

	public String getUpdior() {
		return updior;
	}

	public void setUpdior(String updior) {
		this.updior = updior;
	}

	public String getUpdr() {
		return updr;
	}

	public void setUpdr(String updr) {
		this.updr = updr;
	}

	public String getUpdiom() {
		return updiom;
	}

	public void setUpdiom(String updiom) {
		this.updiom = updiom;
	}

	public String getUbdm() {
		return ubdm;
	}

	public void setUbdm(String ubdm) {
		this.ubdm = ubdm;
	}

	public String getUum() {
		return uum;
	}

	public void setUum(String uum) {
		this.uum = uum;
	}

	@Override
	public String toString() {
		return "UserMngDTO [uname=" + uname + ", unum=" + unum + ", uposition=" + uposition + ", cname=" + cname
				+ ", updv=" + updv + ", updior=" + updior + ", updr=" + updr + ", updiom=" + updiom + ", ubdm=" + ubdm
				+ ", uum=" + uum + "]";
	}

}
