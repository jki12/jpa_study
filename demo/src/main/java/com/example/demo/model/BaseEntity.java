package com.example.demo.model;

import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private OffsetDateTime createdDate;

    @PrePersist
    public void setCreatedDate() {
        createdDate = OffsetDateTime.now();
    }
}
