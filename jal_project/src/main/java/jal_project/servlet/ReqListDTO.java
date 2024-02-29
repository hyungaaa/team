package jal_project.servlet;


public class ReqListDTO {
    private String rid;
    private String uuid;
    private String rcategory;

    public ReqListDTO() {
    }

    public ReqListDTO(String rid, String uuid, String rcategory) {
        this.rid = rid;
        this.uuid = uuid;
        this.rcategory = rcategory;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRcategory() {
        return rcategory;
    }

    public void setRcategory(String rcategory) {
        this.rcategory = rcategory;
    }
    
	@Override
	public String toString() {
		return "reqListDTO [rid=" + rid + ", uuid=" + uuid + ", rcategory=" + rcategory + "]";
	}
	
	
}
