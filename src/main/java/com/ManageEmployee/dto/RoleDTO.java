package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDTO extends BaseDTO {

    private String code;

    private String name;


    private Set<UserDTO> listUser = new HashSet<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserDTO> getListUser() {
        return listUser;
    }

    public void setListUser(Set<UserDTO> listUser) {
        this.listUser = listUser;
    }
}
