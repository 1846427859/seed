package com.example.demo.mapper;

import com.example.demo.dto.SysAccountDto;
import com.example.demo.pojo.SysAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAccountMapper {

    int insertSysAccount(SysAccountDto sysRole);

    int deleteSysAccountById(int id);

    int updateSysAccountById(SysAccountDto sysRole);

    SysAccountDto selectSysAccountById(int id);

    List<SysAccountDto> selectSysAccount();

    SysAccount selectSysAccountByAccount(String username);
}
