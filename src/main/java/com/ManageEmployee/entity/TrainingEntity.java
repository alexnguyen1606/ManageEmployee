package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training")
public class TrainingEntity extends BaseEntity{
    @Column(name = "code",columnDefinition = "NVARCHAR(255)")
    private String code;
    @Column(name = "name",columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name="totaltime")
    private Integer totalTime;
    @Column(name ="description",columnDefinition = "NVARCHAR(255)")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "training")
    private Set<TrainingEmployeeEntity> listTrainingEmployee = new HashSet<>();

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TrainingEmployeeEntity> getListTrainingEmployee() {
        return listTrainingEmployee;
    }

    public void setListTrainingEmployee(Set<TrainingEmployeeEntity> listTrainingEmployee) {
        this.listTrainingEmployee = listTrainingEmployee;
    }
}
