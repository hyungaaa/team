
//package Mng;
//
//import java.sql.Date;
//
//public class UserMngDTO {
//	private String uuid;
//	private String ccode;
//	private String upass;
//	private String uname;
//	private String utel;
//	private String uemail;
//	private String unum;
//	private String uposition;
//	private Date ubirth;
//	private String uimage;
//	private String udate;
//	private String umaster;
//	private String ulevel;
//	private String updv;
//	private String updior;
//	private String updr;
//	private String updiom;
//	private String ubdm;
//	private String uum;
//	String rcategory;
//
//	public String getUuid() {
//		return uuid;
//	}
//
//	public String getRcategory() {
//		return rcategory;
//	}
//
//	public void setRcategory(String rcategory) {
//		this.rcategory = rcategory;
//	}
//
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
//
//	public String getCcode() {
//		return ccode;
//	}
//
//	public void setCcode(String ccode) {
//		this.ccode = ccode;
//	}
//
//	public String getUpass() {
//		return upass;
//	}
//
//	public void setUpass(String upass) {
//		this.upass = upass;
//	}
//
//	public String getUname() {
//		return uname;
//	}
//
//	public void setUname(String uname) {
//		this.uname = uname;
//	}
//
//	public String getUtel() {
//		return utel;
//	}
//
//	public void setUtel(String utel) {
//		this.utel = utel;
//	}
//
//	public String getUemail() {
//		return uemail;
//	}
//
//	public void setUemail(String uemail) {
//		this.uemail = uemail;
//	}
//
//	public String getUnum() {
//		return unum;
//	}
//
//	public void setUnum(String unum) {
//		this.unum = unum;
//	}
//
//	public String getUposition() {
//		return uposition;
//	}
//
//	public void setUposition(String uposition) {
//		this.uposition = uposition;
//	}
//
//	public Date getUbirth() {
//		return ubirth;
//	}
//
//	public void setUbirth(Date ubirth) {
//		this.ubirth = ubirth;
//	}
//
//	public String getUimage() {
//		return uimage;
//	}
//
//	public void setUimage(String uimage) {
//		this.uimage = uimage;
//	}
//
//	public String getUdate() {
//		return udate;
//	}
//
//	public void setUdate(String udate) {
//		this.udate = udate;
//	}
//
//	public String getUmaster() {
//		return umaster;
//	}
//
//	public void setUmaster(String umaster) {
//		this.umaster = umaster;
//	}
//
//	public String getUlevel() {
//		return ulevel;
//	}
//
//	public void setUlevel(String ulevel) {
//		this.ulevel = ulevel;
//	}
//
//	public String getUpdv() {
//		return updv;
//	}
//
//	public void setUpdv(String updv) {
//		this.updv = updv;
//	}
//
//	public String getUpdior() {
//		return updior;
//	}
//
//	public void setUpdior(String updior) {
//		this.updior = updior;
//	}
//
//	public String getUpdr() {
//		return updr;
//	}
//
//	public void setUpdr(String updr) {
//		this.updr = updr;
//	}
//
//	public String getUpdiom() {
//		return updiom;
//	}
//
//	public void setUpdiom(String updiom) {
//		this.updiom = updiom;
//	}
//
//	public String getUbdm() {
//		return ubdm;
//	}
//
//	public void setUbdm(String ubdm) {
//		this.ubdm = ubdm;
//	}
//
//	public String getUum() {
//		return uum;
//	}
//
//	public void setUum(String uum) {
//		this.uum = uum;
//	}
//
//	@Override
//	public String toString() {
//		return "UserMngDTO [uuid=" + uuid + ", ccode=" + ccode + ", upass=" + upass + ", uname=" + uname + ", utel="
//				+ utel + ", uemail=" + uemail + ", unum=" + unum + ", uposition=" + uposition + ", ubirth=" + ubirth
//				+ ", uimage=" + uimage + ", udate=" + udate + ", umaster=" + umaster + ", ulevel=" + ulevel + ", updv="
//				+ updv + ", updior=" + updior + ", updr=" + updr + ", updiom=" + updiom + ", ubdm=" + ubdm + ", uum="
//				+ uum + ", rcategory=" + rcategory + "]";
//	}
//
//	// Getters and setters
//}

//package Mng;
//
//import java.sql.Date;
//
//public class UserMngDTO {
//	// UserInfoDTO fields
//	private String userInfoUuid;
//	private String userInfoCcode;
//	private String userInfoUpass;
//	private String userInfoUname;
//	private String userInfoUtel;
//	private String userInfoUemail;
//	private String userInfoUnum;
//	private String userInfoUposition;
//	private Date userInfoUbirth;
//	private String userInfoUimage;
//	private String userInfoUdate;
//	private String userInfoUmaster;
//	private String userInfoUlevel;
//	private String userInfoUpdv;
//	private String userInfoUpdior;
//	private String userInfoUpdr;
//	private String userInfoUpdiom;
//	private String userInfoUbdm;
//	private String userInfoUum;
//
//	// CenterListDTO fields
//	private String centerListCcode;
//	private String centerListCname;
//	private String centerListCmanager;
//	private String centerListCtel;
//
//	// ReqListDTO fields
//	private String reqListRid;
//	private String reqListUuid;
//	private String reqListRcategory;
//
//	// UserPowerDTO fields
//	private String userPowerUuid;
//	private String userPowerUlevel;
//	private String userPowerUpdv;
//	private String userPowerUpdior;
//	private String userPowerUpdr;
//	private String userPowerUpdiom;
//	private String userPowerUbdm;
//	private String userPowerUum;
//
//	public String getUserInfoUuid() {
//		return userInfoUuid;
//	}
//
//	public void setUserInfoUuid(String userInfoUuid) {
//		this.userInfoUuid = userInfoUuid;
//	}
//
//	public String getUserInfoCcode() {
//		return userInfoCcode;
//	}
//
//	public void setUserInfoCcode(String userInfoCcode) {
//		this.userInfoCcode = userInfoCcode;
//	}
//
//	public String getUserInfoUpass() {
//		return userInfoUpass;
//	}
//
//	public void setUserInfoUpass(String userInfoUpass) {
//		this.userInfoUpass = userInfoUpass;
//	}
//
//	public String getUserInfoUname() {
//		return userInfoUname;
//	}
//
//	public void setUserInfoUname(String userInfoUname) {
//		this.userInfoUname = userInfoUname;
//	}
//
//	public String getUserInfoUtel() {
//		return userInfoUtel;
//	}
//
//	public void setUserInfoUtel(String userInfoUtel) {
//		this.userInfoUtel = userInfoUtel;
//	}
//
//	public String getUserInfoUemail() {
//		return userInfoUemail;
//	}
//
//	public void setUserInfoUemail(String userInfoUemail) {
//		this.userInfoUemail = userInfoUemail;
//	}
//
//	public String getUserInfoUnum() {
//		return userInfoUnum;
//	}
//
//	public void setUserInfoUnum(String userInfoUnum) {
//		this.userInfoUnum = userInfoUnum;
//	}
//
//	public String getUserInfoUposition() {
//		return userInfoUposition;
//	}
//
//	public void setUserInfoUposition(String userInfoUposition) {
//		this.userInfoUposition = userInfoUposition;
//	}
//
//	public Date getUserInfoUbirth() {
//		return userInfoUbirth;
//	}
//
//	public void setUserInfoUbirth(Date userInfoUbirth) {
//		this.userInfoUbirth = userInfoUbirth;
//	}
//
//	public String getUserInfoUimage() {
//		return userInfoUimage;
//	}
//
//	public void setUserInfoUimage(String userInfoUimage) {
//		this.userInfoUimage = userInfoUimage;
//	}
//
//	public String getUserInfoUdate() {
//		return userInfoUdate;
//	}
//
//	public void setUserInfoUdate(String userInfoUdate) {
//		this.userInfoUdate = userInfoUdate;
//	}
//
//	public String getUserInfoUmaster() {
//		return userInfoUmaster;
//	}
//
//	public void setUserInfoUmaster(String userInfoUmaster) {
//		this.userInfoUmaster = userInfoUmaster;
//	}
//
//	public String getUserInfoUlevel() {
//		return userInfoUlevel;
//	}
//
//	public void setUserInfoUlevel(String userInfoUlevel) {
//		this.userInfoUlevel = userInfoUlevel;
//	}
//
//	public String getUserInfoUpdv() {
//		return userInfoUpdv;
//	}
//
//	public void setUserInfoUpdv(String userInfoUpdv) {
//		this.userInfoUpdv = userInfoUpdv;
//	}
//
//	public String getUserInfoUpdior() {
//		return userInfoUpdior;
//	}
//
//	public void setUserInfoUpdior(String userInfoUpdior) {
//		this.userInfoUpdior = userInfoUpdior;
//	}
//
//	public String getUserInfoUpdr() {
//		return userInfoUpdr;
//	}
//
//	public void setUserInfoUpdr(String userInfoUpdr) {
//		this.userInfoUpdr = userInfoUpdr;
//	}
//
//	public String getUserInfoUpdiom() {
//		return userInfoUpdiom;
//	}
//
//	public void setUserInfoUpdiom(String userInfoUpdiom) {
//		this.userInfoUpdiom = userInfoUpdiom;
//	}
//
//	public String getUserInfoUbdm() {
//		return userInfoUbdm;
//	}
//
//	public void setUserInfoUbdm(String userInfoUbdm) {
//		this.userInfoUbdm = userInfoUbdm;
//	}
//
//	public String getUserInfoUum() {
//		return userInfoUum;
//	}
//
//	public void setUserInfoUum(String userInfoUum) {
//		this.userInfoUum = userInfoUum;
//	}
//
//	public String getCenterListCcode() {
//		return centerListCcode;
//	}
//
//	public void setCenterListCcode(String centerListCcode) {
//		this.centerListCcode = centerListCcode;
//	}
//
//	public String getCenterListCname() {
//		return centerListCname;
//	}
//
//	public void setCenterListCname(String centerListCname) {
//		this.centerListCname = centerListCname;
//	}
//
//	public String getCenterListCmanager() {
//		return centerListCmanager;
//	}
//
//	public void setCenterListCmanager(String centerListCmanager) {
//		this.centerListCmanager = centerListCmanager;
//	}
//
//	public String getCenterListCtel() {
//		return centerListCtel;
//	}
//
//	public void setCenterListCtel(String centerListCtel) {
//		this.centerListCtel = centerListCtel;
//	}
//
//	public String getReqListRid() {
//		return reqListRid;
//	}
//
//	public void setReqListRid(String reqListRid) {
//		this.reqListRid = reqListRid;
//	}
//
//	public String getReqListUuid() {
//		return reqListUuid;
//	}
//
//	public void setReqListUuid(String reqListUuid) {
//		this.reqListUuid = reqListUuid;
//	}
//
//	public String getReqListRcategory() {
//		return reqListRcategory;
//	}
//
//	public void setReqListRcategory(String reqListRcategory) {
//		this.reqListRcategory = reqListRcategory;
//	}
//
//	public String getUserPowerUuid() {
//		return userPowerUuid;
//	}
//
//	public void setUserPowerUuid(String userPowerUuid) {
//		this.userPowerUuid = userPowerUuid;
//	}
//
//	public String getUserPowerUlevel() {
//		return userPowerUlevel;
//	}
//
//	public void setUserPowerUlevel(String userPowerUlevel) {
//		this.userPowerUlevel = userPowerUlevel;
//	}
//
//	public String getUserPowerUpdv() {
//		return userPowerUpdv;
//	}
//
//	public void setUserPowerUpdv(String userPowerUpdv) {
//		this.userPowerUpdv = userPowerUpdv;
//	}
//
//	public String getUserPowerUpdior() {
//		return userPowerUpdior;
//	}
//
//	public void setUserPowerUpdior(String userPowerUpdior) {
//		this.userPowerUpdior = userPowerUpdior;
//	}
//
//	public String getUserPowerUpdr() {
//		return userPowerUpdr;
//	}
//
//	public void setUserPowerUpdr(String userPowerUpdr) {
//		this.userPowerUpdr = userPowerUpdr;
//	}
//
//	public String getUserPowerUpdiom() {
//		return userPowerUpdiom;
//	}
//
//	public void setUserPowerUpdiom(String userPowerUpdiom) {
//		this.userPowerUpdiom = userPowerUpdiom;
//	}
//
//	public String getUserPowerUbdm() {
//		return userPowerUbdm;
//	}
//
//	public void setUserPowerUbdm(String userPowerUbdm) {
//		this.userPowerUbdm = userPowerUbdm;
//	}
//
//	public String getUserPowerUum() {
//		return userPowerUum;
//	}
//
//	public void setUserPowerUum(String userPowerUum) {
//		this.userPowerUum = userPowerUum;
//	}
//
//	@Override
//	public String toString() {
//		return "UserMngDTO [userInfoUuid=" + userInfoUuid + ", userInfoCcode=" + userInfoCcode + ", userInfoUpass="
//				+ userInfoUpass + ", userInfoUname=" + userInfoUname + ", userInfoUtel=" + userInfoUtel
//				+ ", userInfoUemail=" + userInfoUemail + ", userInfoUnum=" + userInfoUnum + ", userInfoUposition="
//				+ userInfoUposition + ", userInfoUbirth=" + userInfoUbirth + ", userInfoUimage=" + userInfoUimage
//				+ ", userInfoUdate=" + userInfoUdate + ", userInfoUmaster=" + userInfoUmaster + ", userInfoUlevel="
//				+ userInfoUlevel + ", userInfoUpdv=" + userInfoUpdv + ", userInfoUpdior=" + userInfoUpdior
//				+ ", userInfoUpdr=" + userInfoUpdr + ", userInfoUpdiom=" + userInfoUpdiom + ", userInfoUbdm="
//				+ userInfoUbdm + ", userInfoUum=" + userInfoUum + ", centerListCcode=" + centerListCcode
//				+ ", centerListCname=" + centerListCname + ", centerListCmanager=" + centerListCmanager
//				+ ", centerListCtel=" + centerListCtel + ", reqListRid=" + reqListRid + ", reqListUuid=" + reqListUuid
//				+ ", reqListRcategory=" + reqListRcategory + ", userPowerUuid=" + userPowerUuid + ", userPowerUlevel="
//				+ userPowerUlevel + ", userPowerUpdv=" + userPowerUpdv + ", userPowerUpdior=" + userPowerUpdior
//				+ ", userPowerUpdr=" + userPowerUpdr + ", userPowerUpdiom=" + userPowerUpdiom + ", userPowerUbdm="
//				+ userPowerUbdm + ", userPowerUum=" + userPowerUum + "]";
//	}
//
//}
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

	// user_power table fields
	private String ulevel;
	private String updv;
	private String updior;
	private String updr;
	private String updiom;
	private String ubdm;
	private String uum;

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
				+ ", ulevel=" + ulevel + ", updv=" + updv + ", updior=" + updior + ", updr=" + updr + ", updiom="
				+ updiom + ", ubdm=" + ubdm + ", uum=" + uum + "]";
	}

}
