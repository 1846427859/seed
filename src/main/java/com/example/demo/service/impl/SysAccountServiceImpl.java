package com.example.demo.service.impl;

import com.example.demo.dto.SysAccountDto;
import com.example.demo.mapper.SysAccountMapper;
import com.example.demo.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysAccountServiceImpl implements SysAccountService {
    
    @Autowired(required = false)
    private SysAccountMapper accountMapper;
    
    @Override
    public int insertSysAccount(SysAccountDto sysAccount) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(sysAccount.getPassword());
        sysAccount.setPassword(password);
        return accountMapper.insertSysAccount(sysAccount);
    }

    @Override
    public int deleteSysAccountById(int id) {
        return accountMapper.deleteSysAccountById(id);
    }

    @Override
    public int updateSysAccountById(SysAccountDto sysAccount) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        SysAccountDto accountDto = selectSysAccountById(sysAccount.getId());
        String newPassword = sysAccount.getPassword();
        String oldPassword1 = accountDto.getPassword();
        if (!encoder.matches(newPassword, oldPassword1)) {
            String password = encoder.encode(sysAccount.getPassword());
            sysAccount.setPassword(password);
        }
        return accountMapper.updateSysAccountById(sysAccount);
    }

    @Override
    public SysAccountDto selectSysAccountById(int id) {
        return accountMapper.selectSysAccountById(id);
    }

    @Override
    public List<SysAccountDto> selectSysAccount() {
        return accountMapper.selectSysAccount();
    }
}
