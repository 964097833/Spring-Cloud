package cn.yqd.bean;



import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    /** 用户编号 */
    @Column(name="user_no",nullable = true)
    private String userNo;
    /** 用户名称 */
    @Column(name="user_name",nullable = true)
    private String userName;
    /** 用户密码 */
    @Column(name="user_pwd",nullable = true)
    private String userPwd;
    /** 用户id */
    @Id//主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自動生成
    @Column(name="id",nullable = true)
    private int id;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", id=" + id +
                '}';
    }
}
