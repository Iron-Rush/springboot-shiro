package cn.czl.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
@Repository
public class User implements Serializable {
    private Integer uid;
    private Integer pid;
    private String uname;
    private String upwd;
    private String usex;
    private String utext;
    private String ucdate;
    private String uldate;
    private String perms;
    private String role;

    public User() {
    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User(Integer uid, String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.ucdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.uldate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", pid=" + pid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex='" + usex + '\'' +
                ", utext='" + utext + '\'' +
                ", ucdate='" + ucdate + '\'' +
                ", uldate='" + uldate + '\'' +
                ", perms='" + perms + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUtext() {
        return utext;
    }

    public void setUtext(String utext) {
        this.utext = utext;
    }

    public String getUcdate() {
        return ucdate;
    }

    public void setUcdate(String ucdate) {
        this.ucdate = ucdate;
    }

    public String getUldate() {
        return uldate;
    }

    public void setUldate(String uldate) {
        this.uldate = uldate;
    }
}
