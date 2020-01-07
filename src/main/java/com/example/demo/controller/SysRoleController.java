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
        SysRoleDto groupDto = new SysRoleDto();
        groupDto.setParentId(0);
        groupDto.setName("test1");
        groupDto.setCreateTime(new Date());
        groupDto.setDescription("test1");
        int row = roleService.insertSysRole(groupDto);
        return groupDto;
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
        SysRoleDto groupDto = new SysRoleDto();
        groupDto.setId(1);
        groupDto.setParentId(0);
        groupDto.setCreateTime(new Date());
        groupDto.setName("test2");
        groupDto.setDescription("test2");
        int row = roleService.updateSysRoleById(groupDto);
        return groupDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysRoleById", method = RequestMethod.GET)
    public SysRoleDto selectSysRoleById(int id) {
        SysRoleDto groupDto = roleService.selectSysRoleById(id);
        return groupDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysRole", method = RequestMethod.GET)
    public List<SysRoleDto> selectSysRole() {
        List<SysRoleDto>  roleDtos = roleService.selectSysRole();
        return roleDtos;
    }

}
