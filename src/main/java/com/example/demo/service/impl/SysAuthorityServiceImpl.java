package com.example.demo.service.impl;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.mapper.SysAuthorityMapper;
import com.example.demo.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysAuthorityServiceImpl implements SysAuthorityService {

    @Autowired(required = false)
    private SysAuthorityMapper authorityMapper;

    @Override
    public int insertSysAuthority(SysAuthorityDto sysAuthority) {
        return authorityMapper.insertSysAuthority(sysAuthority);
    }

    @Override
    public int deleteSysAuthorityById(int id) {
        return authorityMapper.deleteSysAuthorityById(id);
    }

    @Override
    public int updateSysAuthorityById(SysAuthorityDto sysAuthority) {
        return authorityMapper.updateSysAuthorityById(sysAuthority);
    }

    @Override
    public SysAuthorityDto selectSysAuthorityById(int id) {
        return authorityMapper.selectSysAuthorityById(id);
    }

    @Override
    public List<SysAuthorityDto> selectSysAuthority() {
        return authorityMapper.selectSysAuthority();
    }
}
