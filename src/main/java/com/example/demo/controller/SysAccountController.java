package com.example.demo.controller;

import com.example.demo.dto.SysAccountDto;
import com.example.demo.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysAccountController {

    @Autowired
    private SysAccountService accountService;

    @PreAuthorize("hasAnyRole('vip')")
    @ResponseBody
    @RequestMapping(value = "/insertSysAccount", method = RequestMethod.POST)
    public SysAccountDto insertSysAccount(SysAccountDto sysAccount) {
        int row = accountService.insertSysAccount(sysAccount);
        return sysAccount;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSysAccountById", method = RequestMethod.POST)
    public String deleteSysAccountById(int id) {
        int row = accountService.deleteSysAccountById(id);
        if(row == 1) {
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSysAccountById", method = RequestMethod.POST)
    public SysAccountDto updateSysAccountById(SysAccountDto sysAccount) {
        int row = accountService.updateSysAccountById(sysAccount);
        return sysAccount;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysAccountById", method = RequestMethod.GET)
    public SysAccountDto selectSysAccountById(int id) {
        SysAccountDto accountDto = accountService.selectSysAccountById(id);
        return accountDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysAccount", method = RequestMethod.GET)
    public List<SysAccountDto> selectSysAccount() {
        List<SysAccountDto> roleDtos = accountService.selectSysAccount();
        return roleDtos;
    }


}
