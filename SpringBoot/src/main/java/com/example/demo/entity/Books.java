package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Books {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String title; //title varchar(50) not null

    private int price; //기본이 not null
    private String writer; //String 기본값 varchar(255), null
    private int page;
}
