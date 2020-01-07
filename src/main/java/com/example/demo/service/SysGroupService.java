package com.example.demo.service;

import com.example.demo.dto.SysGroupDto;

import java.util.List;

public interface SysGroupService {

    int insertSysGroup(SysGroupDto sysAuthority);

    int deleteSysGroupById(int id);

    int updateSysGroupById(SysGroupDto sysAuthority);

    SysGroupDto selectSysGroupById(int id);

    List<SysGroupDto> selectSysGroup();
}
