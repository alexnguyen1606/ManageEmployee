package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends BaseDTO {

    private String code;

    private String name;


    private List<UserDTO> listUser = new ArrayList<>();

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

    public List<UserDTO> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserDTO> listUser) {
        this.listUser = listUser;
    }
}
