package cn.yqd.dao;

import cn.yqd.bean.Account;
import cn.yqd.bean.MessageVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountDao {

    @Insert("INSERT INTO `account`(`account_id`,`password`) VALUES (#{accountid},#{password})")
    int addAccount(Account account);

    @Delete("DELETE FROM `account` WHERE `account_id`=#{accountid}")
    int deleteByAccountid(String accountid);

    @Update("UPDATE `account` set `account_id`=`#{account.accountid}`,`password`=`#{account.password}`" +
            "WHERE `account_id`=#{account.accountid}")
    int updateAccount(@Param("account") Account account);

    @Select("SELECT * FROM `account` WHERE `account_id`=#{accountid2}")
    @Results({
            @Result(id = true,property = "accountid",column = "account_id"),
            @Result(property = "password",column = "password")
    })
    Account queryByAccountid(@Param("accountid2") String accountid);

    @Select("SELECT * FROM `account`")
    @Results({
            @Result(id = true,property = "accountid",column = "account_id"),
            @Result(property = "password",column = "password")
    })
    List<Account> findAll();

    @Select("SELECT accountid,message FROM message,account WHERE account_id=#{accountid2}")
    List<MessageVO> queryMessageByAccountid(@Param("accountid2") String accountid);

}
