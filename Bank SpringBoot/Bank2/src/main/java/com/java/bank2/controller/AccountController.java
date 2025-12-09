package com.java.bank2.controller;


import com.java.bank2.model.Account;
import com.java.bank2.model.Trans;
import com.java.bank2.repo.TransRepository;
import com.java.bank2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransRepository transRepository;

    @GetMapping(value = "/showAccount")
    public List<Account> showAccount() {
        System.out.println(accountService.findAll().size());
        return accountService.findAll();
    }


    @DeleteMapping(value = "/deleteAccount/{accountNo}")
    public String deleteAccount(@PathVariable int accountNo) {
        return accountService.deleteByAccountNo(accountNo);
    }

    @PostMapping(value = "/addAccount")
    public String createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping(value = "/search/{accno}")
    public Account searchAccount(@PathVariable int accno) {
        return accountService.findByAccountNo(accno);
    }

    @GetMapping(value = "/showTrans/{accountNo}")
    public List<Trans> showTrans(@PathVariable int accountNo) {
        return accountService.showAllTrans(accountNo);
    }

    @PostMapping(value = "/deposit/{accountNo}/{depositAmount}")
    public String deposit(@PathVariable int accountNo, @PathVariable double depositAmount) {
        return accountService.depositAmount(accountNo, depositAmount);
    }

    @PostMapping(value = "/withdraw/{accountNo}/{withdrawAmount}")
    public String withdraw(@PathVariable int accountNo, @PathVariable double withdrawAmount) {
        return accountService.withdrawAccount(accountNo, withdrawAmount);
    }
}
