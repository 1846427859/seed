package com.example.demo.controller;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;
import com.example.demo.service.AssignPrivilegeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/assignAuthorityToRole", method = RequestMethod.POST)
    public void assignAuthorityToRole(int[] authorityIds, int[] roleIds, int type) {
        System.out.println(Arrays.toString(roleIds));
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.assignAuthorityToRole(authorityIds, roleIds, type);

    }

    @ResponseBody
    @RequestMapping(value = "/assignAuthorityToGroup", method = RequestMethod.POST)
    public void assignAuthorityToGroup(int[] authorityIds, int[] groupIds, int type) {
        System.out.println(Arrays.toString(groupIds));
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.assignAuthorityToGroup(authorityIds, groupIds, type);

    }

    @ResponseBody
    @RequestMapping(value = "/assignAuthorityToAccount", method = RequestMethod.POST)
    public void assignAuthorityToAccount(int[] authorityIds, int[] accountIds, int type) {
        System.out.println(Arrays.toString(accountIds));
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.assignAuthorityToAccount(authorityIds, accountIds, type);

    }

    @ResponseBody
    @RequestMapping(value = "/assignRoleToGroup", method = RequestMethod.POST)
    public void assignRoleToGroup(int[] roleIds, int[] groupIds) {
        System.out.println(Arrays.toString(roleIds));
        System.out.println(Arrays.toString(groupIds));
        assignPrivilegeService.assignRoleToGroup(roleIds, groupIds);

    }

    @ResponseBody
    @RequestMapping(value = "/assignRoleToAccount", method = RequestMethod.POST)
    public void assignRoleToAccount(int[] roleIds, int[] accountIds) {
        System.out.println(Arrays.toString(roleIds));
        System.out.println(Arrays.toString(accountIds));
        assignPrivilegeService.assignRoleToAccount(roleIds, accountIds);

    }

    @ResponseBody
    @RequestMapping(value = "/assignGroupToAccount", method = RequestMethod.POST)
    public void assignGroupToAccount(int[] groupIds, int[] accountIds) {
        System.out.println(Arrays.toString(groupIds));
        System.out.println(Arrays.toString(accountIds));
        assignPrivilegeService.assignGroupToAccount(groupIds, accountIds);

    }

    //--------------------------------------------回收权限--------------------------------------------------------------

    /**
     * 从角色中回收权限
     * @param roleId
     * @param authorityIds
     */
    @ResponseBody
    @RequestMapping(value = "/recoveryAuthorityFromRole", method = RequestMethod.POST)
    public void recoveryAuthorityFromRole(int roleId, int[] authorityIds) {
        System.out.println(roleId);
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.recoveryAuthorityFromRole(roleId, authorityIds);

    }

    @ResponseBody
    @RequestMapping(value = "/recoveryAuthorityFromGroup", method = RequestMethod.POST)
    public void recoveryAuthorityFromGroup(int groupId, int[] authorityIds) {
        System.out.println(groupId);
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.recoveryAuthorityFromGroup(groupId, authorityIds);
    }

    @ResponseBody
    @RequestMapping(value = "/recoveryAuthorityFromAccount", method = RequestMethod.POST)
    public void recoveryAuthorityFromAccount(int accountId, int[] authorityIds) {
        System.out.println(accountId);
        System.out.println(Arrays.toString(authorityIds));
        assignPrivilegeService.recoveryAuthorityFromAccount(accountId, authorityIds);
    }

    @ResponseBody
    @RequestMapping(value = "/recoveryRoleFromGroup", method = RequestMethod.POST)
    public void recoveryRoleFromGroup(int groupId, int[] roleIds) {
        System.out.println(groupId);
        System.out.println(Arrays.toString(roleIds));
        assignPrivilegeService.recoveryRoleFromGroup(groupId, roleIds);
    }

    @ResponseBody
    @RequestMapping(value = "/recoveryRoleFromAccount", method = RequestMethod.POST)
    public void recoveryRoleFromAccount(int accountId, int[] roleIds) {
        System.out.println(accountId);
        System.out.println(Arrays.toString(roleIds));
        assignPrivilegeService.recoveryRoleFromAccount(accountId, roleIds);
    }

    @ResponseBody
    @RequestMapping(value = "/recoveryGroupFromAccount", method = RequestMethod.POST)
    public void recoveryGroupFromAccount(int accountId, int[] groupIds) {
        System.out.println(accountId);
        System.out.println(Arrays.toString(groupIds));
        assignPrivilegeService.recoveryGroupFromAccount(accountId, groupIds);
    }

    //--------------------------------------------查询权限--------------------------------------------------------------

    @ApiOperation("查看指定角色的权限")
    @ResponseBody
    @RequestMapping(value = "/selectAuthorityFromRole", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromRole(int roleId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromRole(roleId);
        return authorities;
    }

    @ApiOperation("查看指定权限组的权限")
    @ResponseBody
    @RequestMapping(value = "/selectAuthorityFromGroup", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromGroup(int groupId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromGroup(groupId);
        return authorities;
    }

    @ApiOperation("查看指定账号的权限")
    @ResponseBody
    @RequestMapping(value = "/selectAuthorityFromAccount", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectAuthorityFromAccount(int accountId) {
        List<SysAuthorityDto> authorities = assignPrivilegeService.selectAuthorityFromAccount(accountId);
        return authorities;
    }

    @ApiOperation("查看指定账号的角色")
    @ResponseBody
    @RequestMapping(value = "/selectRoleFromAccount", method = RequestMethod.GET)
    public List<SysRoleDto> selectRoleFromAccount(int accountId) {
        List<SysRoleDto> roleDtos = assignPrivilegeService.selectRoleFromAccount(accountId);
        return roleDtos;
    }

    @ApiOperation("查看指定权限组的角色")
    @ResponseBody
    @RequestMapping(value = "/selectRoleFromGroup", method = RequestMethod.GET)
    public List<SysRoleDto> selectRoleFromGroup(int groupId) {
        List<SysRoleDto> roleDtos = assignPrivilegeService.selectRoleFromGroup(groupId);
        return roleDtos;
    }

    @ApiOperation("查看指定账号的权限组")
    @ResponseBody
    @RequestMapping(value = "/selectGroupFromAccount", method = RequestMethod.GET)
    public List<SysGroupDto> selectGroupFromAccount(int accountId) {
        List<SysGroupDto> groupDtos = assignPrivilegeService.selectGroupFromAccount(accountId);
        return groupDtos;
    }

}

































