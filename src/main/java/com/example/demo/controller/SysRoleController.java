package com.example.demo.controller;

import com.example.demo.dto.SysRoleDto;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/insertSysRole", method = RequestMethod.POST)
    public SysRoleDto insertSysRole(SysRoleDto sysRole) {
        sysRole.setCreateTime(new Date());
        int row = roleService.insertSysRole(sysRole);
        return sysRole;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSysRoleById", method = RequestMethod.POST)
    public String deleteSysRoleById(int id) {
        int row = roleService.deleteSysRoleById(id);
        if(row == 1) {
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSysRoleById", method = RequestMethod.POST)
    public SysRoleDto updateSysRoleById(SysRoleDto sysRole) {
        int row = roleService.updateSysRoleById(sysRole);
        return sysRole;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysRoleById", method = RequestMethod.GET)
    public SysRoleDto selectSysRoleById(int id) {
        SysRoleDto roleDto = roleService.selectSysRoleById(id);
        return roleDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysRole", method = RequestMethod.GET)
    public List<SysRoleDto> selectSysRole() {
        List<SysRoleDto>  roleDtos = roleService.selectSysRole();
        return roleDtos;
    }

}
