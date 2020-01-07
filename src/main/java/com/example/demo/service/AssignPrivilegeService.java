package com.example.demo.service;

public interface AssignPrivilegeService {

    void assignAuthorityToRole(int[] authorityIds, int[] roleIds, int type);

    void assignAuthorityToGroup(int[] authorityIds, int[] groupIds, int type);

    void assignAuthorityToAccount(int[] authorityIds, int[] accountIds, int type);

    void assignRoleToGroup(int[] roleIds, int[] groupIds);

    void assignRoleToAccount(int[] roleIds, int[] accountIds);

    void assignGroupToAccount(int[] groupIds, int[] accountIds);

    void recoveryAuthorityFromRole(int roleId, int[] authorityIds);

}
