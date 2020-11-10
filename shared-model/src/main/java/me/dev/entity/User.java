package me.dev.entity;

import javax.persistence.Entity;

@Entity
public class User extends AuditEntity<Integer> {

    private String username;
    private String password;
    private Boolean isExpired;
    private Boolean isLocked;
    //private List<Role> roles;

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

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }
/*
    @ManyToMany
    @JoinTable(name = "USER_ROLE"
            ,joinColumns =@JoinColumn(name = "USER_ID")
            ,inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/
}
