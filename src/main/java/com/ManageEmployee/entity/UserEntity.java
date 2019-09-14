package com.ManageEmployee.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name ="users")
@Entity
public class UserEntity  extends BaseEntity{
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name = "email",columnDefinition = "NVARCHAR(255)")
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> listRole = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleEntity> getListRole() {
        return listRole;
    }

    public void setListRole(Set<RoleEntity> listRole) {
        this.listRole = listRole;
    }
}
