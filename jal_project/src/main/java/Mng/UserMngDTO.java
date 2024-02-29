package Mng;

import java.sql.Date;

public class UserMngDTO {

	String uuid;
	String ccode;
	String cname;
	String upass;
	String uname;
	String utel;
	String uemail;
	String unum;
	String uposition;
	String ubirth;
	String uimage;
	String udate;
	String umaster;

	String cmanager;
	String ctel;

	String ulevel;
	String updv;
	String updior;
	String updr;
	String updiom;
	String updm;
	String uum;

	String rid;
	String rcategory;

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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUimage() {
		return uimage;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public String getUmaster() {
		return umaster;
	}

	public void setUmaster(String umaster) {
		this.umaster = umaster;
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

	public String getUpdm() {
		return updm;
	}

	public void setUpdm(String updm) {
		this.updm = updm;
	}

	public String getUum() {
		return uum;
	}

	public void setUum(String uum) {
		this.uum = uum;
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

	@Override
	public String toString() {
		return "UserMngDTO [uuid=" + uuid + ", ccode=" + ccode + ", cname=" + cname + ", upass=" + upass + ", uname="
				+ uname + ", utel=" + utel + ", uemail=" + uemail + ", unum=" + unum + ", uposition=" + uposition
				+ ", ubirth=" + ubirth + ", uimage=" + uimage + ", udate=" + udate + ", umaster=" + umaster
				+ ", cmanager=" + cmanager + ", ctel=" + ctel + ", ulevel=" + ulevel + ", updv=" + updv + ", updior="
				+ updior + ", updr=" + updr + ", updiom=" + updiom + ", updm=" + updm + ", uum=" + uum + ", rid=" + rid
				+ ", rcategory=" + rcategory + "]";
	}

}

