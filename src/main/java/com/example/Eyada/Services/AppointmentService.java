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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto requestDto) {
        Doctor doctor = doctorRepository.findById(requestDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(requestDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(requestDto.getAppointmentDate());
        appointment.setStatus(AppointmentStatus.PENDING);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentResponseDto(savedAppointment.getId(),
                new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSpecialization(),
                        doctor.getExperience(), doctor.getAvailability(), doctor.getContact()),
                new PatientDto(patient.getId(), patient.getName(), patient.getEmail(),
                        patient.getContact(), patient.getAge(), patient.getMedicalHistory()),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getStatus());
    }

    public List<AppointmentResponseDto> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId).stream()
                .map(appointment -> new AppointmentResponseDto(
                        appointment.getId(),
                        new DoctorDto(appointment.getDoctor().getId(), appointment.getDoctor().getName(),
                                appointment.getDoctor().getSpecialization(), appointment.getDoctor().getExperience(),
                                appointment.getDoctor().getAvailability(), appointment.getDoctor().getContact()),
                        new PatientDto(appointment.getPatient().getId(), appointment.getPatient().getName(),
                                appointment.getPatient().getEmail(), appointment.getPatient().getContact(),
                                appointment.getPatient().getAge(), appointment.getPatient().getMedicalHistory()),
                        appointment.getAppointmentDate(),
                        appointment.getStatus()))
                .collect(Collectors.toList());
    }
}
//@Service
//public class AppointmentService {
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    public Appointment Add(AppointmentDTO dto){
//        if(doctorRepository.existsById(dto.getDoctorId()))
//        {
//           return appointmentRepository.save(Appointment.toEntit(dto)); // appointment id not initialized yet
//        }
//        else
//            return null;
//    }
//
//    public AppointmentDTO GetById(Integer id){
//        if(appointmentRepository.existsById(id)){
//            return AppointmentDTO.toDTO(appointmentRepository.findById(id).orElse(null));
//        }
//        else
//            return null;
//    }
//
//    public List<Appointment> GetAll(){
//        List<Appointment> appointments = appointmentRepository.findAll();
//        return appointments;
//    }
//
//    public Appointment Update(AppointmentDTO dto){
//        if(doctorRepository.existsById(dto.getDoctorId()))
//        {
//            return appointmentRepository.save(Appointment.toEntit(dto)); // appointment id not initialized yet
//        }
//        else
//            return null;
//    }
//
//    public boolean Delete (Integer id){
//        appointmentRepository.deleteById(id);
//        if(!appointmentRepository.existsById(id))
//            return true;
//        else
//            return false;
//    }
//}
