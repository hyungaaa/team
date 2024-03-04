package Mng;

import java.sql.Date;

public class UserMngDTO {
	// user_info table fields
	private String uuid;
	private String ccode;
	private String upass;
	private String uname;
	private String utel;
	private String uemail;
	private String unum;
	private String uposition;
	private Date ubirth;
	private String uimage;
	private Date udate;
	private String umaster;

	// center_list table fields
	private String cname;
	private String cmanager;
	private String ctel;

	// req_list table fields
	private String rid;
	private String rcategory;
	private String uemail1;
	private String uuid1;

	// user_power table fields
	private String ulevel;
	private String updv;
	private String updior;
	private String updr;
	private String updiom;
	private String ubdm;
	private String uum;

	public String getUemail1() {
		return uemail1;
	}

	public void setUemail1(String uemail1) {
		this.uemail1 = uemail1;
	}

	public String getUuid1() {
		return uuid1;
	}

	public void setUuid1(String uuid1) {
		this.uuid1 = uuid1;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public Date getUbirth() {
		return ubirth;
	}

	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}

	public String getUimage() {
		return uimage;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getUmaster() {
		return umaster;
	}

	public void setUmaster(String umaster) {
		this.umaster = umaster;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmanager() {
		return cmanager;
	}

	public void setCmanager(String cmanager) {
		this.cmanager = cmanager;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRcategory() {
		return rcategory;
	}

	public void setRcategory(String rcategory) {
		this.rcategory = rcategory;
	}

	public String getUlevel() {
		return ulevel;
	}

	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
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
		return "UserMngDTO [uuid=" + uuid + ", ccode=" + ccode + ", upass=" + upass + ", uname=" + uname + ", utel="
				+ utel + ", uemail=" + uemail + ", unum=" + unum + ", uposition=" + uposition + ", ubirth=" + ubirth
				+ ", uimage=" + uimage + ", udate=" + udate + ", umaster=" + umaster + ", cname=" + cname
				+ ", cmanager=" + cmanager + ", ctel=" + ctel + ", rid=" + rid + ", rcategory=" + rcategory
				+ ", uemail1=" + uemail1 + ", uuid1=" + uuid1 + ", ulevel=" + ulevel + ", updv=" + updv + ", updior="
				+ updior + ", updr=" + updr + ", updiom=" + updiom + ", ubdm=" + ubdm + ", uum=" + uum + "]";
	}

}
