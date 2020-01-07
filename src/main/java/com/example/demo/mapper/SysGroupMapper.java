package com.example.demo.mapper;

import com.example.demo.dto.SysGroupDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysGroupMapper {

    int insertSysGroup(SysGroupDto SysGroup);

    int deleteSysGroupById(int id);

    int updateSysGroupById(SysGroupDto SysGroup);

    SysGroupDto selectSysGroupById(int id);

    List<SysGroupDto> selectSysGroup();

}
