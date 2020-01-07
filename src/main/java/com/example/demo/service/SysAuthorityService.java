package com.example.demo.service;

import com.example.demo.dto.SysAuthorityDto;

import java.util.List;

public interface SysAuthorityService {

    int insertSysAuthority(SysAuthorityDto sysAuthority);

    int deleteSysAuthorityById(int id);

    int updateSysAuthorityById(SysAuthorityDto sysAuthority);

    SysAuthorityDto selectSysAuthorityById(int id);

    List<SysAuthorityDto> selectSysAuthority();
}
