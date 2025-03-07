package com.ECommerceIMS.ECIMS.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;
}
