package com.example.Eyada.Models.Entities;

import com.example.Eyada.Models.DTOs.AppointmentDto;
import com.example.Eyada.Models.DTOs.AppointmentRequestDto;
import com.example.Eyada.Models.Enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "doctor_id",
            nullable = false
    )
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            nullable = false
    )
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status; // PENDING, CONFIRMED, CANCELED, COMPLETED

    public Appointment(Long doctorId, Long patientId, LocalDateTime appointmentDate) {
        this.doctor.setId(doctorId);
        this.patient.setId(patientId);
        this.appointmentDate = appointmentDate;
    }

    public static Appointment fromDto(@NotNull AppointmentRequestDto dto){
        return new Appointment(
                dto.getDoctorId(),
                dto.getPatientId(),
                dto.getAppointmentDate()
        );
    }
    public static Appointment fromDto(AppointmentDto dto , Doctor doctor , Patient patient){
        return new Appointment(
                dto.getId(),
                doctor ,
                patient,
                dto.getAppointmentDate(),
                dto.getStatus()
        );
    }
}
