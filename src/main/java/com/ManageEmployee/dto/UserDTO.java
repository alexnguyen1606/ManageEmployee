package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends BaseDTO{

    private String username;

    private String password;

    private String email;
    private List<RoleDTO> listRole = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDTO> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleDTO> listRole) {
        this.listRole = listRole;
    }
}
