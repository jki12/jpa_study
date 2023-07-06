package com.example.demo.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    private static int totalCount = 0;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter private String name;

    public Member(String name) {
        totalCount++;

        this.name = name;
    }
}

