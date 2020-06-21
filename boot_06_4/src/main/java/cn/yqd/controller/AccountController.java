package cn.yqd.controller;

import cn.yqd.bean.Account;
import cn.yqd.bean.MessageVO;
import cn.yqd.dao.AccountDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    /**
     * 分页查询
     * @param page 第几页
     * @param pageSize 每页多少数据
     * @return
     */
    @GetMapping({"/","/index/{page}/{pageSize}"})
    public List<Account> selectAcounts(@PathVariable int page, @PathVariable int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Account> accounts = accountDao.findAll();
        PageInfo<Account> infoPage = new PageInfo<>(accounts);
        List<Account> list = infoPage.getList();
        return list;
    }
//    public List<Account> findAll() {
//        return accountDao.findAll();
//    }

    @GetMapping("/query/{accountid}")
    public Account queryByAccountid(@PathVariable String accountid) {
        return accountDao.queryByAccountid(accountid);
    }

    @GetMapping("/update/{accountid}/{password}")
    public int updateAccount(@PathVariable String accountid,@PathVariable String password) {
        Account account = new Account();
        account.setAccountid(accountid);
        account.setPassword(password);
        return accountDao.updateAccount(account);
    }

    @GetMapping("/delete/{accountid}")
    public int deleteByAccountid(@PathVariable String accountid) {
        return accountDao.deleteByAccountid(accountid);
    }

    @GetMapping("/add/{accountid}/{password}")
    public int addAccount(@PathVariable String accountid,@PathVariable String password) {
        Account account = new Account();
        account.setAccountid(accountid);
        account.setPassword(password);
        return accountDao.addAccount(account);
    }

    @GetMapping("/query/message/{accountid}")
    public List<MessageVO> queryMessage(@PathVariable String accountid) {
        return accountDao.queryMessageByAccountid(accountid);
    }



}
