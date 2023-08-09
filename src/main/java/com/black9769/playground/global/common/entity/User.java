package com.black9769.playground.global.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 1000)
    private String name;

    @Column(name = "gender", length = 1000)
    private String gender;

    @Column(name = "city", length = 1000)
    private String city;

}