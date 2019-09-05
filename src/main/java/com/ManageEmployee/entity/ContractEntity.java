package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contract")
public class ContractEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "type")
    private int type;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "contract",cascade = CascadeType.ALL)
    private Set<ContractEmployeeEntity> listContractEmployee = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<ContractEmployeeEntity> getListContractEmployee() {
        return listContractEmployee;
    }

    public void setListContractEmployee(Set<ContractEmployeeEntity> listContractEmployee) {
        this.listContractEmployee = listContractEmployee;
    }
}
