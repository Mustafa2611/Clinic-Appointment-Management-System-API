package com.example.Eyada.Controllers;

import com.example.Eyada.Models.DTOs.DoctorDTO;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @RequestMapping("/add_Doctor")
    public ResponseEntity<String> AddDoctor(DoctorDTO doctorDTO){
        Doctor doctor = doctorService.Add(doctorDTO);
        if(doctor == null)
            return ResponseEntity.badRequest().body("Invalid Data.");
        else
            return ResponseEntity.ok("Doctor added successfully!!");
    }

    @GetMapping
    @RequestMapping("/get_doctor_by_id")
    public ResponseEntity<DoctorDTO> GetById(Integer id){
        Doctor doctor = doctorService.GetById(id);
        if(doctor ==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(DoctorDTO.toDTO(doctor));
    }

    @GetMapping
    @RequestMapping("/get_doctors")
    public ResponseEntity<List<DoctorDTO>> GetAll(){
        List<Doctor> doctors = doctorService.GetAll();
        if(doctors ==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(List.of(DoctorDTO.toDTO((Doctor) doctors)));    }

    @GetMapping
    @RequestMapping("/update_doctor")
    public ResponseEntity<String> Update(DoctorDTO doctorDTO){
        Doctor doctor = doctorService.Update(doctorDTO);
        if(doctor == null)
            return ResponseEntity.badRequest().body("Invalid data");
        else
            return ResponseEntity.ok("doctor Data has been updated.\n\n"+
                    "doctor ID: "+ doctor.getId()+"\n\n"+
                    "doctor Name: "+ doctor.getName()+"\n\n"+
                    "doctor Specification: "+ doctor.getSpecification()+"\n\n"+
                    "doctor's Patients: "+ doctor.getPatients()+"\n\n"
            );
    }
    @GetMapping
    @RequestMapping("/delete_doctor_by_id")
    public ResponseEntity<String> Delete(Integer id){
         doctorService.Delete(id);
         if(doctorService.GetById(id)==null)
             return ResponseEntity.ok("Data of the Doctor deleted");
         else
             return ResponseEntity.notFound().build();
    }
}
