package com.example.demo.service.impl;

import com.example.demo.mapper.AssignPrivilegeMapper;
import com.example.demo.service.AssignPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssignPrivilegeServiceImpl implements AssignPrivilegeService {

    @Autowired(required = false)
    private AssignPrivilegeMapper assignPrivilegeMapper;

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
}

























