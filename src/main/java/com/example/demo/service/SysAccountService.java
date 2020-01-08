package com.example.demo.service;

import com.example.demo.dto.SysAccountDto;

import java.util.List;

public interface SysAccountService {

    int insertSysAccount(SysAccountDto sysAccount);

    int deleteSysAccountById(int id);

    int updateSysAccountById(SysAccountDto sysAccount);

    SysAccountDto selectSysAccountById(int id);

    List<SysAccountDto> selectSysAccount();
}
