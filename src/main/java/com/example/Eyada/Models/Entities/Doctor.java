package com.example.Eyada.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer Id;

    private String Name ;

    @ManyToOne
    @JoinColumn(name="specification_id")
    private Specification specification;

    @ManyToMany(mappedBy = "patients")
    private List<Patient> patients;
}
