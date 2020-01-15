package com.example.demo.controller;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;
import com.example.demo.service.AssignPrivilegeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class AssignPrivilegeController {

    @Autowired
    private AssignPrivilegeService assignPrivilegeService;

    //--------------------------------------------授权------------------------------------------------------------------

    @ResponseBody
    @PreAuthorize("hasAuthority('assignAuthorityToRole')")
    @RequestMapping(value = "/assignAuthorityToRole", method = RequestMethod.POST)
    public void assignAuthorityToRole(int[] authorityIds, int[] roleIds, int type) {
        assignPrivilegeService.assignAuthorityToRole(authorityIds, roleIds, type);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('assignAuthorityToGroup')")
    @RequestMapping(value = "/assignAuthorityToGroup", method = RequestMethod.POST)
    public void assignAuthorityToGroup(int[] authorityIds, int[] groupIds, int type) {
        assignPrivilegeService.assignAuthorityToGroup(authorityIds, groupIds, type);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('assignAuthorityToAccount')")
    @RequestMapping(value = "/assignAuthorityToAccount", method = RequestMethod.POST)
    public void assignAuthorityToAccount(int[] authorityIds, int[] accountIds, int type) {
        assignPrivilegeService.assignAuthorityToAccount(authorityIds, accountIds, type);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('assignRoleToGroup')")
    @RequestMapping(value = "/assignRoleToGroup", method = RequestMethod.POST)
    public void assignRoleToGroup(int[] roleIds, int[] groupIds) {
        assignPrivilegeService.assignRoleToGroup(roleIds, groupIds);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('assignRoleToAccount')")
    @RequestMapping(value = "/assignRoleToAccount", method = RequestMethod.POST)
    public void assignRoleToAccount(int[] roleIds, int[] accountIds) {
        assignPrivilegeService.assignRoleToAccount(roleIds, accountIds);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('assignGroupToAccount')")
    @RequestMapping(value = "/assignGroupToAccount", method = RequestMethod.POST)
    public void assignGroupToAccount(int[] groupIds, int[] accountIds) {
        assignPrivilegeService.assignGroupToAccount(groupIds, accountIds);

    }

    //--------------------------------------------回收权限--------------------------------------------------------------

    /**
     * 从角色中回收权限
     * @param roleId
     * @param authorityIds
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryAuthorityFromRole')")
    @RequestMapping(value = "/recoveryAuthorityFromRole", method = RequestMethod.POST)
    public void recoveryAuthorityFromRole(int roleId, int[] authorityIds) {
        assignPrivilegeService.recoveryAuthorityFromRole(roleId, authorityIds);

    }

    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryAuthorityFromGroup')")
    @RequestMapping(value = "/recoveryAuthorityFromGroup", method = RequestMethod.POST)
    public void recoveryAuthorityFromGroup(int groupId, int[] authorityIds) {
        assignPrivilegeService.recoveryAuthorityFromGroup(groupId, authorityIds);
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryAuthorityFromAccount')")
    @RequestMapping(value = "/recoveryAuthorityFromAccount", method = RequestMethod.POST)
    public void recoveryAuthorityFromAccount(int accountId, int[] authorityIds) {
        assignPrivilegeService.recoveryAuthorityFromAccount(accountId, authorityIds);
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryRoleFromGroup')")
    @RequestMapping(value = "/recoveryRoleFromGroup", method = RequestMethod.POST)
    public void recoveryRoleFromGroup(int groupId, int[] roleIds) {
        assignPrivilegeService.recoveryRoleFromGroup(groupId, roleIds);
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryRoleFromAccount')")
    @RequestMapping(value = "/recoveryRoleFromAccount", method = RequestMethod.POST)
    public void recoveryRoleFromAccount(int accountId, int[] roleIds) {
        assignPrivilegeService.recoveryRoleFromAccount(accountId, roleIds);
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('recoveryGroupFromAccount')")
    @RequestMapping(value = "/recoveryGroupFromAccount", method = RequestMethod.POST)
    public void recoveryGroupFromAccount(int accountId, int[] groupIds) {
        assignPrivilegeService.recoveryGroupFromAccount(accountId, groupIds);
    }

    //--------------------------------------------查询权限--------------------------------------------------------------

    @ApiOperation("查看指定角色的权限")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectAuthorityFromRole')")
    @RequestMapping(value = "/selectAuthorityFromRole", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromRole(int roleId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromRole(roleId);
        return authorities;
    }

    @ApiOperation("查看指定权限组的权限")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectAuthorityFromGroup')")
    @RequestMapping(value = "/selectAuthorityFromGroup", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromGroup(int groupId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromGroup(groupId);
        return authorities;
    }

    @ApiOperation("查看指定账号的权限")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectAuthorityFromAccount')")
    @RequestMapping(value = "/selectAuthorityFromAccount", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromAccount(int accountId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromAccount(accountId);
        return authorities;
    }

    @ApiOperation("查看指定账号的角色")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectRoleFromAccount')")
    @RequestMapping(value = "/selectRoleFromAccount", method = RequestMethod.GET)
    public List<SysRoleDto> selectRoleFromAccount(int accountId) {
        List<SysRoleDto> roleDtos = assignPrivilegeService.selectRoleFromAccount(accountId);
        return roleDtos;
    }

    @ApiOperation("查看指定权限组的角色")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectRoleFromGroup')")
    @RequestMapping(value = "/selectRoleFromGroup", method = RequestMethod.GET)
    public List<SysRoleDto> selectRoleFromGroup(int groupId) {
        List<SysRoleDto> roleDtos = assignPrivilegeService.selectRoleFromGroup(groupId);
        return roleDtos;
    }

    @ApiOperation("查看指定账号的权限组")
    @ResponseBody
    @PreAuthorize("hasAuthority('selectGroupFromAccount')")
    @RequestMapping(value = "/selectGroupFromAccount", method = RequestMethod.GET)
    public List<SysGroupDto> selectGroupFromAccount(int accountId) {
        List<SysGroupDto> groupDtos = assignPrivilegeService.selectGroupFromAccount(accountId);
        return groupDtos;
    }

}
