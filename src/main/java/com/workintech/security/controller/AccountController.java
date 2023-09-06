package com.workintech.security.controller;

import com.workintech.security.entity.Account;
import com.workintech.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable int id){
        return accountService.findById(id);
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable int id, @RequestBody Account account){
        Account foundAccount = accountService.findById(id);
        if(foundAccount != null){
            account.setId(id);
            return accountService.save(account);
        }
        return null;

    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        return accountService.delete(id);
    }


}
