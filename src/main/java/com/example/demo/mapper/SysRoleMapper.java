package com.example.demo.mapper;

import com.example.demo.dto.SysRoleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    int insertSysRole(SysRoleDto sysRole);

    int deleteSysRoleById(int id);

    int updateSysRoleById(SysRoleDto sysRole);

    SysRoleDto selectSysRoleById(int id);

    List<SysRoleDto> selectSysRole();

}
