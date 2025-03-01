package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.AppointmentDTO;
import com.example.Eyada.Models.Entities.Appointment;
import com.example.Eyada.Repositories.AppointmentRepo;
import com.example.Eyada.Repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public Appointment Add(AppointmentDTO dto){
        if(doctorRepo.existsById(dto.getDoctorId()))
        {
           return appointmentRepo.save(Appointment.toEntit(dto)); // appointment id not initialized yet
        }
        else
            return null;
    }

    public AppointmentDTO GetById(Integer id){
        if(appointmentRepo.existsById(id)){
            return AppointmentDTO.toDTO(appointmentRepo.findById(id).orElse(null));
        }
        else
            return null;
    }

    public List<Appointment> GetAll(){
        List<Appointment> appointments = appointmentRepo.findAll();
        return appointments;
    }

    public Appointment Update(AppointmentDTO dto){
        if(doctorRepo.existsById(dto.getDoctorId()))
        {
            return appointmentRepo.save(Appointment.toEntit(dto)); // appointment id not initialized yet
        }
        else
            return null;
    }

    public boolean Delete (Integer id){
        appointmentRepo.deleteById(id);
        if(!appointmentRepo.existsById(id))
            return true;
        else
            return false;
    }
}
