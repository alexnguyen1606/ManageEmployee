package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "part")
public class PartEntity extends BaseEntity{
    @Column(name = "name",columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name = "description",columnDefinition = "NVARCHAR(255)")
    private String description;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

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

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
