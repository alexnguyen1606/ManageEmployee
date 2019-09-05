package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "part")
public class PartEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "part",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<DepartmentEntity> listDepartment = new HashSet<>();

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

    public Set<DepartmentEntity> getListDepartment() {
        return listDepartment;
    }

    public void setListDepartment(Set<DepartmentEntity> listDepartment) {
        this.listDepartment = listDepartment;
    }
}
