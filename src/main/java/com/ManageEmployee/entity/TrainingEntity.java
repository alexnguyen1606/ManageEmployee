package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training")
public class TrainingEntity extends BaseEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name ="description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "training")
    private Set<TrainingEmployeeEntity> listTrainingEmployee = new HashSet<>();
}
