package Mng;


public class UserMngDTO2 {

	private String unum;

	private String rid;
	private String rcategory;
	private String uemail;
	private String uuid;

	public String getUnum() {
		return unum;
	}

	public void setUnum(String unum) {
		this.unum = unum;
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

	@Override
	public String toString() {
		return "UserMngDTO2 [unum=" + unum + ", rid=" + rid + ", rcategory=" + rcategory + ", uemail=" + uemail
				+ ", uuid=" + uuid + "]";
	}

}
