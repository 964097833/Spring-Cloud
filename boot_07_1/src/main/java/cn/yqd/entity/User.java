package cn.yqd.entity;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 如果不加序列化则可能报如下错误
     *  No serializer found for class com.zfx.entity.User and no properties discovered to create BeanSerializer
     *  (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
     */
    private static final long serialVersionUID = 1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        super();
        this.username = username;
        this.age = age;
    }
    public User() {
        super();
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
