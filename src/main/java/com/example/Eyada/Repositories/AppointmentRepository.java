package com.example.Eyada.Repositories;

import com.example.Eyada.Models.Entities.Appointment;
import com.example.Eyada.Models.Enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByStatus(AppointmentStatus status);
    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);
}
