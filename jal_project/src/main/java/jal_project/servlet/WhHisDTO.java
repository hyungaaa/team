package jal_project.servlet;
import java.util.Date;

public class WhHisDTO {
    private int wid;
    private String wzone;
    private Date wdate;
    private int wcnt;
    private int wpercent;
    
    // 생성자
    public WhHisDTO(int wid, String wzone, Date wdate, int wcnt, int wpercent) {
        this.wid = wid;
        this.wzone = wzone;
        this.wdate = wdate;
        this.wcnt = wcnt;
        this.wpercent = wpercent;
    }
    
    // Getter 및 Setter 메서드
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWzone() {
        return wzone;
    }

    public void setWzone(String wzone) {
        this.wzone = wzone;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public int getWcnt() {
        return wcnt;
    }

    public void setWcnt(int wcnt) {
        this.wcnt = wcnt;
    }

    public int getWpercent() {
        return wpercent;
    }

    public void setWpercent(int wpercent) {
        this.wpercent = wpercent;
    }
}