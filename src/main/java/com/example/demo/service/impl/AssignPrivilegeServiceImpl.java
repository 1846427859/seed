package com.example.demo.service.impl;

import com.example.demo.dto.SysAccountDto;
import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;
import com.example.demo.mapper.AssignPrivilegeMapper;
import com.example.demo.mapper.SysAccountMapper;
import com.example.demo.mapper.SysAuthorityMapper;
import com.example.demo.service.AssignPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssignPrivilegeServiceImpl implements AssignPrivilegeService {

    @Autowired(required = false)
    private AssignPrivilegeMapper assignPrivilegeMapper;

    @Autowired(required = false)
    private SysAccountMapper accountMapper;

    @Autowired(required = false)
    private SysAuthorityMapper authorityMapper;

    @Override
    public void assignAuthorityToRole(int[] authorityIds, int[] roleIds, int type) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            for (int j = 0; j < roleIds.length; j++) {
                int roleId = roleIds[j];
                int row = assignPrivilegeMapper.insertSysRoleAuthority(roleId, authorityId, type);
            }
        }
    }

    @Override
    public void assignAuthorityToGroup(int[] authorityIds, int[] groupIds, int type) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            for (int j = 0; j < groupIds.length; j++) {
                int groupId = groupIds[j];
                int row = assignPrivilegeMapper.insertSysGroupAuthority(groupId, authorityId, type);
            }
        }
    }

    @Override
    public void assignAuthorityToAccount(int[] authorityIds, int[] accountIds, int type) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            for (int j = 0; j < accountIds.length; j++) {
                int accountId = accountIds[j];
                int row = assignPrivilegeMapper.insertSysAccountAuthority(accountId, authorityId, type);
            }
        }
    }

    @Override
    public void assignRoleToGroup(int[] roleIds, int[] groupIds) {
        for (int i = 0; i < roleIds.length; i++) {
            int roleId = roleIds[i];
            for (int j = 0; j < groupIds.length; j++) {
                int groupId = groupIds[j];
                int row = assignPrivilegeMapper.insertSysGroupRole(groupId, roleId);
            }
        }
    }

    @Override
    public void assignRoleToAccount(int[] roleIds, int[] accountIds) {
        for (int i = 0; i < roleIds.length; i++) {
            int roleId = roleIds[i];
            for (int j = 0; j < accountIds.length; j++) {
                int accountId = accountIds[j];
                int row = assignPrivilegeMapper.insertSysAccountRole(accountId, roleId);
            }
        }
    }

    @Override
    public void assignGroupToAccount(int[] groupIds, int[] accountIds) {
        for (int i = 0; i < groupIds.length; i++) {
            int groupId = groupIds[i];
            for (int j = 0; j < accountIds.length; j++) {
                int accountId = accountIds[j];
                int row = assignPrivilegeMapper.insertSysAccountGroup(accountId, groupId);
            }
        }
    }

    @Override
    public void recoveryAuthorityFromRole(int roleId, int[] authorityIds) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            int row = assignPrivilegeMapper.deleteSysRoleAuthority(roleId, authorityId);
        }

    }

    @Override
    public void recoveryAuthorityFromGroup(int groupId, int[] authorityIds) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            int row = assignPrivilegeMapper.deleteSysGroupAuthority(groupId, authorityId);
        }
    }

    @Override
    public void recoveryAuthorityFromAccount(int accountId, int[] authorityIds) {
        for (int i = 0; i < authorityIds.length; i++) {
            int authorityId = authorityIds[i];
            int row = assignPrivilegeMapper.deleteSysAccountAuthority(accountId, authorityId);
        }
    }

    @Override
    public void recoveryRoleFromGroup(int groupId, int[] roleIds) {
        for (int i = 0; i < roleIds.length; i++) {
            int roleId = roleIds[i];
            int row = assignPrivilegeMapper.deleteSysGroupRole(groupId, roleId);
        }
    }

    @Override
    public void recoveryRoleFromAccount(int accountId, int[] roleIds) {
        for (int i = 0; i < roleIds.length; i++) {
            int roleId = roleIds[i];
            int row = assignPrivilegeMapper.deleteSysAccountRole(accountId, roleId);
        }
    }

    @Override
    public void recoveryGroupFromAccount(int accountId, int[] groupIds) {
        for (int i = 0; i < groupIds.length; i++) {
            int groupId = groupIds[i];
            int row = assignPrivilegeMapper.deleteSysAccountGroup(accountId, groupId);
        }
    }

    @Override
    public List<SysAuthorityDto> selectAuthorityFromRole(int roleId) {
        List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromRole(roleId);
        return authorities;
    }

    @Override
    public List<SysAuthorityDto> selectAuthorityFromGroup(int groupId) {
        List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromGroup(groupId);
        return authorities;
    }

    @Override
    public List<SysAuthorityDto> selectAuthorityFromAccount(int accountId) {
        List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromAccount(accountId);
        return authorities;
    }

    @Override
    public List<SysRoleDto> selectRoleFromAccount(int accountId) {
        List<SysRoleDto> roleDtos = assignPrivilegeMapper.selectRoleFromAccount(accountId);
        return roleDtos;
    }

    @Override
    public List<SysRoleDto> selectRoleFromGroup(int groupId) {
        List<SysRoleDto> roleDtos = assignPrivilegeMapper.selectRoleFromGroup(groupId);
        return roleDtos;
    }

    @Override
    public List<SysGroupDto> selectGroupFromAccount(int accountId) {
        List<SysGroupDto> groupDtos = assignPrivilegeMapper.selectGroupFromAccount(accountId);
        return groupDtos;
    }

    @Override
    public List<SysAuthorityDto> selectCanAssignAuthority(int accountId) {
        SysAccountDto accountDto = accountMapper.selectSysAccountById(accountId);
        int id = accountId;
        String account = accountDto.getAccount();
        List<SysAuthorityDto> totalAuthorities = new ArrayList<>();
        if("root".equals(account)) {
            // root 账号拥有所有的权限
            List<SysAuthorityDto> authorityDtos = authorityMapper.selectSysAuthority();
            for (int i = 0; i < authorityDtos.size(); i++) {
                authorityDtos.get(i).setType(1);
            }
            totalAuthorities = authorityDtos;
        } else {
            List<SysGroupDto> groupDtos = assignPrivilegeMapper.selectGroupFromAccount(id);
            List<SysRoleDto> roleDtos = assignPrivilegeMapper.selectRoleFromAccount(id);
            List<SysAuthorityDto> authorityDtos = assignPrivilegeMapper.selectAuthorityFromAccount(id);
            totalAuthorities.addAll(authorityDtos); // 账号拥有的权限
            List<SysRoleDto> totalRoles = new ArrayList<>();
            totalRoles.addAll(roleDtos);
            for (int i = 0; i < groupDtos.size(); i++) {
                SysGroupDto sysGroupDto = groupDtos.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromGroup(sysGroupDto.getId());
                List<SysRoleDto> roles = assignPrivilegeMapper.selectRoleFromGroup(sysGroupDto.getId());
                totalAuthorities.addAll(authorities); // 权限组拥有的权限
                totalRoles.addAll(roles);
            }
            for (int i = 0; i < totalRoles.size(); i++) {
                SysRoleDto sysRoleDto = totalRoles.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromRole(sysRoleDto.getId());
                totalAuthorities.addAll(authorities); // 角色拥有的权限
            }
            List<SysAuthorityDto> tempAuthorities = new ArrayList<>();
            for (int i = 0; i < totalAuthorities.size(); i++) {
                SysAuthorityDto authorityDto = totalAuthorities.get(i);
                Integer type = authorityDto.getType();
                if (type != null && type == 1) {
                    tempAuthorities.add(authorityDto);
                }
            }
            totalAuthorities = tempAuthorities;
        }
        return totalAuthorities;
    }

    @Override
    public List<SysAuthorityDto> selectOwnerAuthority(int accountId) {
        SysAccountDto accountDto = accountMapper.selectSysAccountById(accountId);
        int id = accountId;
        String account = accountDto.getAccount();
        List<SysAuthorityDto> totalAuthorities = new ArrayList<>();
        if("root".equals(account)) {
            // root 账号拥有所有的权限
            List<SysAuthorityDto> authorityDtos = authorityMapper.selectSysAuthority();
            totalAuthorities = authorityDtos;
        } else {
            List<SysGroupDto> groupDtos = assignPrivilegeMapper.selectGroupFromAccount(id);
            List<SysRoleDto> roleDtos = assignPrivilegeMapper.selectRoleFromAccount(id);
            List<SysAuthorityDto> authorityDtos = assignPrivilegeMapper.selectAuthorityFromAccount(id);
            totalAuthorities.addAll(authorityDtos); // 账号拥有的权限
            List<SysRoleDto> totalRoles = new ArrayList<>();
            totalRoles.addAll(roleDtos);
            for (int i = 0; i < groupDtos.size(); i++) {
                SysGroupDto sysGroupDto = groupDtos.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromGroup(sysGroupDto.getId());
                List<SysRoleDto> roles = assignPrivilegeMapper.selectRoleFromGroup(sysGroupDto.getId());
                totalAuthorities.addAll(authorities); // 权限组拥有的权限
                totalRoles.addAll(roles);
            }
            for (int i = 0; i < totalRoles.size(); i++) {
                SysRoleDto sysRoleDto = totalRoles.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromRole(sysRoleDto.getId());
                totalAuthorities.addAll(authorities); // 角色拥有的权限
            }
        }
        return totalAuthorities;
    }
}

























