package com.example.Eyada.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private int experience; // in years

    @Column(nullable = false)
    private String availability; // Example: "Mon-Fri 9 AM - 5 PM"

    @Column(nullable = false)
    private String contact;
}
