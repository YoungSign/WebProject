package sessionremove;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 5979384526527843601L;
    private Integer id;
    private String loginName;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
