package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of ="id")

public class User {
    @Id
    @GeneratedValue()
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

  //  @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;


    /*@JsonManagedReference
    @OneToMany(mappedBy = "userId")
    private List<Feedback> feedbacks;*/



}
