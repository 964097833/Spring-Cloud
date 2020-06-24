package cn.yqd.bean;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	 
    /** 用户id */
    @Id//主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自動生成
    private Long id;
    /** 用户编号 */
    @Column(nullable = true)
    private String userNo;
    /** 用户名称 */
    @Column(nullable = true)
    private String userName;
    /** 用户密码 */
    @Column(nullable = true)
    private String userPwd;
 
    public long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userNo=" + userNo + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
    
}