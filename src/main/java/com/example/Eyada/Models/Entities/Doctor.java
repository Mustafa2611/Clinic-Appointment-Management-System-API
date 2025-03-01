package com.example.Eyada.Models.Entities;

import com.example.Eyada.Models.DTOs.DoctorDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name= "Doctor")
public class Doctor extends User {

    private String Specialization;
    private int ExperienceYears;
    private double ConsultationFee;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "doctor_id")
//    private Integer Id;
//
//    private String Name ;

//    @ManyToOne
//    @JoinColumn(name="specification_id")
//    private Specification specification;

    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    private List<Appointment> appointments;

//    public static Doctor toEntity(DoctorDTO dto){
//        return Doctor.builder()
//
//                .Id(dto.getId())
//                .Name(dto.getName())
//                .specification(dto.getSpecification())
//                .build();
//    }
}
