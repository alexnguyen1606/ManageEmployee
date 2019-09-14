package com.ManageEmployee.service;

import com.ManageEmployee.dto.RoleDTO;

public interface IRoleService  extends GenericService<RoleDTO>{
    public RoleDTO findByCode(String code);
}
