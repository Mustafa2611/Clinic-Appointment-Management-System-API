//package com.example.Eyada.Models.Entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= "Specification")
//public class Specification {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "specification_id")
//    private Integer Id;
//
//    private String Title;
//
//    @OneToMany(mappedBy = "specification" , cascade = CascadeType.ALL)
//    private List<Doctor> doctor;
//}
