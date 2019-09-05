package com.ManageEmployee.dto;


import java.util.ArrayList;

import java.util.List;


public class ContractDTO extends BaseDTO{

    private String code;

    private int type;

    private String description;

    private List<ContractEmployeeDTO> listContractEmployee = new ArrayList<>();

}
