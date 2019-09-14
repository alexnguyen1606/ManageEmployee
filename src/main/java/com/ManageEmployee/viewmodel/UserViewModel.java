package com.ManageEmployee.viewmodel;

import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.dto.UserDTO;

import java.util.List;
import java.util.Set;

public class UserViewModel {
    private UserDTO user;
    private Set<RoleDTO> roles;
    private Set<Integer> listIdRole;

    public Set<Integer> getListIdRole() {
        return listIdRole;
    }

    public void setListIdRole(Set<Integer> listIdRole) {
        this.listIdRole = listIdRole;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
