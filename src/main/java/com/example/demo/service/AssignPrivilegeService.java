package com.example.demo.service;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;

import java.util.List;

public interface AssignPrivilegeService {

    void assignAuthorityToRole(int[] authorityIds, int[] roleIds, int type);

    void assignAuthorityToGroup(int[] authorityIds, int[] groupIds, int type);

    void assignAuthorityToAccount(int[] authorityIds, int[] accountIds, int type);

    void assignRoleToGroup(int[] roleIds, int[] groupIds);

    void assignRoleToAccount(int[] roleIds, int[] accountIds);

    void assignGroupToAccount(int[] groupIds, int[] accountIds);

    void recoveryAuthorityFromRole(int roleId, int[] authorityIds);

    void recoveryAuthorityFromGroup(int groupId, int[] authorityIds);

    void recoveryAuthorityFromAccount(int accountId, int[] authorityIds);

    void recoveryRoleFromGroup(int groupId, int[] roleIds);

    void recoveryRoleFromAccount(int accountId, int[] roleIds);

    void recoveryGroupFromAccount(int accountId, int[] groupIds);

    List<SysAuthorityDto> selectAuthorityFromRole(int roleId);

    List<SysAuthorityDto> selectAuthorityFromGroup(int groupId);

    List<SysAuthorityDto> selectAuthorityFromAccount(int accountId);

    List<SysRoleDto> selectRoleFromAccount(int accountId);

    List<SysRoleDto> selectRoleFromGroup(int groupId);

    List<SysGroupDto> selectGroupFromAccount(int accountId);

    List<SysAuthorityDto> selectCanAssignAuthority(int accountId);

    List<SysAuthorityDto> selectOwnerAuthority(int accountId);
}
