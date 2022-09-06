package com.jojo.springbootrestapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{
    @Id
    @SequenceGenerator(name = "user_sg_gen",
            sequenceName = "user_seg",
            initialValue = 100,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sg_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", length = 100)
    private String firstName;

    @Column(name = "lastName", length = 100)
    private String lastName;
}
