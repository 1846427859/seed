package com.example.demo.controller;

import com.example.demo.dto.SysGroupDto;
import com.example.demo.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/insertSysGroup", method = RequestMethod.POST)
    public SysGroupDto insertSysGroup(SysGroupDto sysAuthority) {
        SysGroupDto groupDto = new SysGroupDto();
        groupDto.setParentId(0);
        groupDto.setName("test1");
        groupDto.setCreateTime(new Date());
        groupDto.setDescription("test1");
        int row = groupService.insertSysGroup(groupDto);
        return groupDto;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSysGroupById", method = RequestMethod.POST)
    public String deleteSysGroupById(int id) {
        int row = groupService.deleteSysGroupById(id);
        if(row == 1) {
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSysGroupById", method = RequestMethod.POST)
    public SysGroupDto updateSysGroupById(SysGroupDto sysAuthority) {
        SysGroupDto groupDto = new SysGroupDto();
        groupDto.setId(1);
        groupDto.setParentId(0);
        groupDto.setCreateTime(new Date());
        groupDto.setName("test2");
        groupDto.setDescription("test2");
        int row = groupService.updateSysGroupById(groupDto);
        return groupDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysGroupById", method = RequestMethod.GET)
    public SysGroupDto selectSysGroupById(int id) {
        SysGroupDto groupDto = groupService.selectSysGroupById(id);
        return groupDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysGroup", method = RequestMethod.GET)
    public List<SysGroupDto> selectSysGroup() {
        List<SysGroupDto>  groupDtos = groupService.selectSysGroup();
        return groupDtos;
    }

}
