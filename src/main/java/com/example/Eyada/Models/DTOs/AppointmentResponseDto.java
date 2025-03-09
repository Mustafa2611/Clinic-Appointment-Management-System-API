package com.example.Eyada.Models.DTOs;

import com.example.Eyada.Models.Enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {
    private Long id;
    private DoctorDto doctor;
    private PatientDto patient;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
}
