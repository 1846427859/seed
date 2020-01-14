package com.example.demo.mapper;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssignPrivilegeMapper {

    int insertSysRoleAuthority(@Param("roleId") int roleId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysGroupAuthority(@Param("groupId") int groupId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysAccountAuthority(@Param("accountId") int accountId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysGroupRole(@Param("groupId") int groupId, @Param("roleId") int roleId);

    int insertSysAccountRole(@Param("accountId") int accountId, @Param("roleId") int roleId);

    int insertSysAccountGroup(@Param("accountId") int accountId, @Param("groupId") int groupId);

    int deleteSysRoleAuthority(@Param("roleId") int roleId, @Param("authorityId") int authorityId);

    int deleteSysGroupAuthority(@Param("groupId") int groupId, @Param("authorityId") int authorityId);

    int deleteSysAccountAuthority(@Param("accountId") int accountId, @Param("authorityId") int authorityId);

    int deleteSysGroupRole(@Param("groupId") int groupId, @Param("roleId") int roleId);

    int deleteSysAccountRole(@Param("accountId") int accountId, @Param("roleId") int roleId);

    int deleteSysAccountGroup(@Param("accountId") int accountId, @Param("groupId") int groupId);

    List<SysAuthorityDto> selectAuthorityFromRole(int roleId);

    List<SysAuthorityDto> selectAuthorityFromGroup(int groupId);

    List<SysAuthorityDto> selectAuthorityFromAccount(int accountId);

    List<SysRoleDto> selectRoleFromAccount(int accountId);

    List<SysRoleDto> selectRoleFromGroup(int groupId);

    List<SysGroupDto> selectGroupFromAccount(int accountId);
}
