package com.example.blablacat.entity;

import javax.persistence.*;

import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "id_company", unique = true)
    private String idCompany;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "validate_by_admin")
    private Boolean validateAdmin;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private List<UserHasCourseEntity> userHasCourseEntityList;

    @OneToMany
    @JoinColumn(name="id_driver", referencedColumnName = "id")
    private List<CourseEntity> courseEntityList;

    public List<UserHasCourseEntity> getUserHasCourseEntityList() {
        return userHasCourseEntityList;
    }

    public void setUserHasCourseEntityList(List<UserHasCourseEntity> userHasCourseEntityList) {
        this.userHasCourseEntityList = userHasCourseEntityList;
    }

    public List<CourseEntity> getCourseEntityList() {
        return courseEntityList;
    }

    public void setCourseEntityList(List<CourseEntity> courseEntityList) {
        this.courseEntityList = courseEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidateAdmin() {
        return validateAdmin;
    }

    public void setValidateAdmin(Boolean validateAdmin) {
        this.validateAdmin = validateAdmin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
