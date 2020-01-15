package com.example.demo.controller;

import com.example.demo.dto.SysGroupDto;
import com.example.demo.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class SysGroupController {

    @Autowired
    private SysGroupService groupService;

    @ResponseBody
    @PreAuthorize("hasAuthority('insertSysGroup')")
    @RequestMapping(value = "/insertSysGroup", method = RequestMethod.POST)
    public SysGroupDto insertSysGroup(SysGroupDto sysGroup) {
        sysGroup.setCreateTime(new Date());
        int row = groupService.insertSysGroup(sysGroup);
        return sysGroup;
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('deleteSysGroupById')")
    @RequestMapping(value = "/deleteSysGroupById", method = RequestMethod.POST)
    public String deleteSysGroupById(int id) {
        int row = groupService.deleteSysGroupById(id);
        if(row == 1) {
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('updateSysGroupById')")
    @RequestMapping(value = "/updateSysGroupById", method = RequestMethod.POST)
    public SysGroupDto updateSysGroupById(SysGroupDto sysGroup) {
        int row = groupService.updateSysGroupById(sysGroup);
        return sysGroup;
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('selectSysGroupById')")
    @RequestMapping(value = "/selectSysGroupById", method = RequestMethod.GET)
    public SysGroupDto selectSysGroupById(int id) {
        SysGroupDto groupDto = groupService.selectSysGroupById(id);
        return groupDto;
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('selectSysGroup')")
    @RequestMapping(value = "/selectSysGroup", method = RequestMethod.GET)
    public List<SysGroupDto> selectSysGroup() {
        List<SysGroupDto>  groupDtos = groupService.selectSysGroup();
        return groupDtos;
    }

}
