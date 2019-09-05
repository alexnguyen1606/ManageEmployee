package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    private Set<EmployeeEntity> listEmployee = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "part_id")
    private PartEntity part;

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

    public PartEntity getPart() {
        return part;
    }

    public void setPart(PartEntity part) {
        this.part = part;
    }
}
