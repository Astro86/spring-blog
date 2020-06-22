package com.example.mysite.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    @Builder
    public Member(String email, String password, String name, int age){
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
}
