package com.example.demo.service.impl;

import com.example.demo.dto.SysRoleDto;
import com.example.demo.mapper.SysRoleMapper;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired(required = false)
    private SysRoleMapper roleMapper;

    @Override
    public int insertSysRole(SysRoleDto sysRole) {
        return roleMapper.insertSysRole(sysRole);
    }

    @Override
    public int deleteSysRoleById(int id) {
        return roleMapper.deleteSysRoleById(id);
    }

    @Override
    public int updateSysRoleById(SysRoleDto sysRole) {
        return roleMapper.updateSysRoleById(sysRole);
    }

    @Override
    public SysRoleDto selectSysRoleById(int id) {
        return roleMapper.selectSysRoleById(id);
    }

    @Override
    public List<SysRoleDto> selectSysRole() {
        return roleMapper.selectSysRole();
    }
}
