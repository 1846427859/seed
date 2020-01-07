package com.example.demo.service;

import com.example.demo.dto.SysRoleDto;

import java.util.List;

public interface SysRoleService {

    int insertSysRole(SysRoleDto sysRole);

    int deleteSysRoleById(int id);

    int updateSysRoleById(SysRoleDto sysRole);

    SysRoleDto selectSysRoleById(int id);

    List<SysRoleDto> selectSysRole();
}
