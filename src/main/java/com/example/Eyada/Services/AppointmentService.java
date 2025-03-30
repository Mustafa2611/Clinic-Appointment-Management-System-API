package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.*;
import com.example.Eyada.Models.Entities.Appointment;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Models.Entities.Patient;
import com.example.Eyada.Models.Enums.AppointmentStatus;
import com.example.Eyada.Repositories.AppointmentRepository;
import com.example.Eyada.Repositories.DoctorRepository;
import com.example.Eyada.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public AppointmentResponseDto bookAppointment(@NotNull AppointmentRequestDto requestDto) {
        Doctor doctor = doctorRepository.findById(requestDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(requestDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = Appointment.fromDto(requestDto);
        appointment.setStatus(AppointmentStatus.PENDING);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentResponseDto(
                savedAppointment.getId(),
                new DoctorDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization(),
                        doctor.getExperience(),
                        doctor.getAvailability(),
                        doctor.getContact()
                ),
                new PatientDto(
                        patient.getId(),
                        patient.getName(),
                        patient.getEmail(),
                        patient.getContact(),
                        patient.getAge(),
                        patient.getMedicalHistory()
                ),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getStatus()
        );
    }

    public List<AppointmentResponseDto> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId)
                .stream()
                .map(
                        appointment -> new AppointmentResponseDto(
                            appointment.getId(),
                            new DoctorDto(
                                    appointment.getDoctor().getId(),
                                    appointment.getDoctor().getName(),
                                    appointment.getDoctor().getSpecialization(),
                                    appointment.getDoctor().getExperience(),
                                    appointment.getDoctor().getAvailability(),
                                    appointment.getDoctor().getContact()),
                            new PatientDto(
                                    appointment.getPatient().getId(),
                                    appointment.getPatient().getName(),
                                    appointment.getPatient().getEmail(),
                                    appointment.getPatient().getContact(),
                                    appointment.getPatient().getAge(),
                                    appointment.getPatient().getMedicalHistory()
                            ),
                            appointment.getAppointmentDate(),
                            appointment.getStatus()
                        )
                )
                .toList();
    }

    public AppointmentDto updateAppointment(@NotNull AppointmentDto appointmentDto){
        Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(appointmentDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = Appointment.fromDto(appointmentDto, doctor, patient );
        appointment.setStatus(AppointmentStatus.PENDING);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentDto(
                savedAppointment.getId(),
                new DoctorDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization(),
                        doctor.getExperience(),
                        doctor.getAvailability(),
                        doctor.getContact()
                ).getId(),
                new PatientDto(
                        patient.getId(),
                        patient.getName(),
                        patient.getEmail(),
                        patient.getContact(),
                        patient.getAge(),
                        patient.getMedicalHistory()
                ).getId(),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getStatus()
        );
    }

    public Boolean deleteAppointment(Long id){
        if(appointmentRepository.findById(id).isPresent()){
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
