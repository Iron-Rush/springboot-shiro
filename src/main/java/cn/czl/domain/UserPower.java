package cn.czl.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Component
@Repository
public class UserPower implements Serializable {
    private Integer pid;
    private String perm;
    private String pcontext;

    @Override
    public String toString() {
        return "UserPower{" +
                "pid=" + pid +
                ", perm='" + perm + '\'' +
                ", pcontext=" + pcontext +
                '}';
    }

    public String getPcontext() {
        return pcontext;
    }

    public void setPcontext(String pcontext) {
        this.pcontext = pcontext;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}
