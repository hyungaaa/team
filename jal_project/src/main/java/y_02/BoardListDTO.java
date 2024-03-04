package y_02;

public class BoardListDTO {
	int bno;
	String uuid;
	String uname;
	String btitle;
	String pnum;
	String bdate;
	String btext;
	int bbits;

	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBbits() {
		return bbits;
	}
	public void setBbits(int bbits) {
		this.bbits = bbits;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBtext() {
		return btext;
	}
	public void setBtext(String btext) {
		this.btext = btext;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	@Override
	public String toString() {
		return "BoardListDTO [bno=" + bno + ", uuid=" + uuid + ", uname =" + uname +", btitle=" + btitle + ", btext=" + btext + ", pnum=" + pnum + ", bdate="
				+ bdate + ", bbits=" + bbits + "]";
	}

	
//	BoardListDTO dto = (BoardListDTO)list.get(i);
//	int bno = dto.getbno();
//	String uuid = dto.getUuid();
//	String btitle = dto.getBitile();	
//	
}
