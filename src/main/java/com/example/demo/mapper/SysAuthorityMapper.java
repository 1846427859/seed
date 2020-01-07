package com.example.demo.mapper;

import com.example.demo.dto.SysAuthorityDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAuthorityMapper {

    int insertSysAuthority(SysAuthorityDto SysAuthority);

    int deleteSysAuthorityById(int id);

    int updateSysAuthorityById(SysAuthorityDto SysAuthority);

    SysAuthorityDto selectSysAuthorityById(int id);

    List<SysAuthorityDto> selectSysAuthority();
}
