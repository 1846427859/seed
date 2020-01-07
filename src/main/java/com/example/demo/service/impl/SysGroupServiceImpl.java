package com.example.demo.service.impl;

import com.example.demo.dto.SysGroupDto;
import com.example.demo.mapper.SysGroupMapper;
import com.example.demo.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysGroupServiceImpl implements SysGroupService {

    @Autowired(required = false)
    private SysGroupMapper groupMapper;

    @Override
    public int insertSysGroup(SysGroupDto sysGroup) {
        return groupMapper.insertSysGroup(sysGroup);
    }

    @Override
    public int deleteSysGroupById(int id) {
        return groupMapper.deleteSysGroupById(id);
    }

    @Override
    public int updateSysGroupById(SysGroupDto sysGroup) {
        return groupMapper.updateSysGroupById(sysGroup);
    }

    @Override
    public SysGroupDto selectSysGroupById(int id) {
        return groupMapper.selectSysGroupById(id);
    }

    @Override
    public List<SysGroupDto> selectSysGroup() {
        return groupMapper.selectSysGroup();
    }

}
