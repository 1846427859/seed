package com.example.demo.config.security;

import com.example.demo.dto.SysAuthorityDto;
import com.example.demo.dto.SysGroupDto;
import com.example.demo.dto.SysRoleDto;
import com.example.demo.mapper.AssignPrivilegeMapper;
import com.example.demo.mapper.SysAccountMapper;
import com.example.demo.mapper.SysAuthorityMapper;
import com.example.demo.pojo.SysAccount;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    private SysAccountMapper accountMapper;

    private SysAuthorityMapper authorityMapper;

    private AssignPrivilegeMapper assignPrivilegeMapper;

    public void setAccountMapper(SysAccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public void setAssignPrivilegeMapper(AssignPrivilegeMapper assignPrivilegeMapper) {
        this.assignPrivilegeMapper = assignPrivilegeMapper;
    }

    public void setAuthorityMapper(SysAuthorityMapper authorityMapper) {
        this.authorityMapper = authorityMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysAccount sysAccount = accountMapper.selectSysAccountByAccount(username);
        if (sysAccount == null) {
            return null;
        }
        int id = sysAccount.getId();
        String password = sysAccount.getPassword();
        boolean enabled = false;
        if(sysAccount.getState() == 1) {
            enabled = true;
        }
        // 权限
        List<SysAuthorityDto> totalAuthorities = new ArrayList<>();
        if("root".equals(username)) {
            // root 账号拥有所有的权限
            List<SysAuthorityDto> authorityDtos = authorityMapper.selectSysAuthority();
            totalAuthorities = authorityDtos;
        } else {
            List<SysGroupDto> groupDtos = assignPrivilegeMapper.selectGroupFromAccount(id);
            List<SysRoleDto> roleDtos = assignPrivilegeMapper.selectRoleFromAccount(id);
            List<SysAuthorityDto> authorityDtos = assignPrivilegeMapper.selectAuthorityFromAccount(id);
            totalAuthorities.addAll(authorityDtos); // 账号拥有的权限
            List<SysRoleDto> totalRoles = new ArrayList<>();
            totalRoles.addAll(roleDtos);
            for (int i = 0; i < groupDtos.size(); i++) {
                SysGroupDto sysGroupDto = groupDtos.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromGroup(sysGroupDto.getId());
                List<SysRoleDto> roles = assignPrivilegeMapper.selectRoleFromGroup(sysGroupDto.getId());
                totalAuthorities.addAll(authorities); // 权限组拥有的权限
                totalRoles.addAll(roles);
            }
            for (int i = 0; i < totalRoles.size(); i++) {
                SysRoleDto sysRoleDto = totalRoles.get(i);
                List<SysAuthorityDto> authorities = assignPrivilegeMapper.selectAuthorityFromRole(sysRoleDto.getId());
                totalAuthorities.addAll(authorities); // 角色拥有的权限
            }
        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (int i = 0; i < totalAuthorities.size(); i++) {
            SysAuthorityDto authorityDto = totalAuthorities.get(i);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authorityDto.getName());
            authorities.add(authority);
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(id, username, password, authorities, enabled);
        return userDetails;
    }
}
