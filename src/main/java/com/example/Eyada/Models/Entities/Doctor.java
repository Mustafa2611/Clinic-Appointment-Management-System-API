package com.example.Eyada.Models.Entities;

import com.example.Eyada.Models.DTOs.DoctorDto;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "specialization",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String specialization;

    @Column(
            name = "experience",
            nullable = false
    )
    private int experience; // in years

    @Column(
            name = "availability",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String availability; // Example: "Mon-Fri 9 AM - 5 PM"

    @Column(
            name = "contact",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contact;

    public Doctor(String name, String contact, String specialization, int experience, String availability) {
        this.name = name;
        this.contact = contact;
        this.availability = availability;
        this.experience = experience;
        this.specialization = specialization;
    }

    @Contract("_ -> new")
    public static @NotNull Doctor fromDto(@NotNull DoctorDto dto){
        return new Doctor(
                dto.getName(),
                dto.getContact(),
                dto.getSpecialization(),
                dto.getExperience(),
                dto.getAvailability()
        );
    }
}
