package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "role_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<UserEntity> listUser = new HashSet<>();

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

    public Set<UserEntity> getListUser() {
        return listUser;
    }

    public void setListUser(Set<UserEntity> listUser) {
        this.listUser = listUser;
    }
}
