package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AssignPrivilegeMapper {

    int insertSysRoleAuthority(@Param("roleId") int roleId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysGroupAuthority(@Param("groupId") int groupId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysAccountAuthority(@Param("accountId") int accountId, @Param("authorityId") int authorityId, @Param("type") int type);

    int insertSysGroupRole(@Param("groupId") int groupId, @Param("roleId") int roleId);

    int insertSysAccountRole(@Param("accountId") int accountId, @Param("roleId") int roleId);

    int insertSysAccountGroup(@Param("accountId") int accountId, @Param("groupId") int groupId);

    int deleteSysRoleAuthority(@Param("roleId") int roleId, @Param("authorityId") int authorityId);
}
