package com.example.demo.controller;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.mapper.SysAuthorityMapper;
import com.example.demo.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysAuthorityController {

    @Autowired
    private SysAuthorityService authorityService;

    @ResponseBody
    @RequestMapping(value = "/insertSysAuthority", method = RequestMethod.POST)
    public SysAuthorityDto insertSysAuthority(SysAuthorityDto sysAuthority) {
        int row = authorityService.insertSysAuthority(sysAuthority);
        return sysAuthority;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSysAuthorityById", method = RequestMethod.POST)
    public String deleteSysAuthorityById(int id) {
        int row = authorityService.deleteSysAuthorityById(id);
        if(row == 1) {
            return "success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSysAuthorityById", method = RequestMethod.POST)
    public SysAuthorityDto updateSysAuthorityById(SysAuthorityDto sysAuthority) {
        int row = authorityService.updateSysAuthorityById(sysAuthority);
        return sysAuthority;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysAuthorityById", method = RequestMethod.GET)
    public SysAuthorityDto selectSysAuthorityById(int id) {
        SysAuthorityDto authorityDto = authorityService.selectSysAuthorityById(id);
        return authorityDto;
    }

    @ResponseBody
    @RequestMapping(value = "/selectSysAuthority", method = RequestMethod.GET)
    public List<SysAuthorityDto> selectSysAuthority() {
        List<SysAuthorityDto>  authorityDtos = authorityService.selectSysAuthority();
        return authorityDtos;
    }

}
