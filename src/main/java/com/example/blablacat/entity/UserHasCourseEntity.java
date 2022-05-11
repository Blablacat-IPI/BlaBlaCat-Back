package com.example.blablacat.entity;

import javax.persistence.*;

@Entity
@Table(name ="Reservations")
public class UserHasCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private CourseEntity courseEntity;

    public Integer getUser_has_course_id() {
        return id;
    }

    public void setUser_has_course_id(Integer user_has_course_id) {
        this.id = user_has_course_id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }
}

