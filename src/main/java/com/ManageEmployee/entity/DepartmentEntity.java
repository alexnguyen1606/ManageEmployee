package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Column(name = "name",columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name = "description",columnDefinition = "NVARCHAR(255)")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private Set<EmployeeEntity> listEmployee = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private Set<PartEntity> listPart = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EmployeeEntity> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(Set<EmployeeEntity> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Set<PartEntity> getListPart() {
        return listPart;
    }

    public void setListPart(Set<PartEntity> listPart) {
        this.listPart = listPart;
    }
}
