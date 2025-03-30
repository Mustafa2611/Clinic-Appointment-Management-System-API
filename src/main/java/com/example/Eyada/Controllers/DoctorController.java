package com.example.Eyada.Controllers;

import com.example.Eyada.Models.DTOs.DoctorDto;
import com.example.Eyada.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<Page<DoctorDto>> getAllDoctors(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Page<DoctorDto> doctorDtos =doctorService.getAllDoctors(PageRequest.of(page, size));
        return ResponseEntity.ok(doctorDtos);
    }

    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.addDoctor(doctorDto));
    }
}
/*
//@RestController
//@RequestMapping("/Doctor")
//public class DoctorController {
//    @Autowired
//    private DoctorService doctorService;
//
//    @PostMapping
//    @RequestMapping("/add_Doctor")
//    public ResponseEntity<String> AddDoctor(DoctorDto doctorDTO){
//        Doctor doctor = doctorService.Add(doctorDTO);
//        if(doctor == null)
//            return ResponseEntity.badRequest().body("Invalid Data.");
//        else
//            return ResponseEntity.ok("Doctor added successfully!!");
//    }
//
//    @GetMapping
//    @RequestMapping("/get_doctor_by_id")
//    public ResponseEntity<DoctorDto> GetById(Integer id){
//        Doctor doctor = doctorService.GetById(id);
//        if(doctor ==null)
//            return ResponseEntity.notFound().build();
//        else
//            return ResponseEntity.ok(DoctorDto.toDTO(doctor));
//    }
//
//    @GetMapping
//    @RequestMapping("/get_doctors")
//    public ResponseEntity<List<DoctorDto>> GetAll(){
//        List<Doctor> doctors = doctorService.GetAll();
//        if(doctors ==null)
//            return ResponseEntity.notFound().build();
//        else
//            return ResponseEntity.ok(List.of(DoctorDto.toDTO((Doctor) doctors)));    }
//
//    @GetMapping
//    @RequestMapping("/update_doctor")
//    public ResponseEntity<String> Update(DoctorDto doctorDTO){
//        Doctor doctor = doctorService.Update(doctorDTO);
//        if(doctor == null)
//            return ResponseEntity.badRequest().body("Invalid data");
//        else
//            return ResponseEntity.ok("doctor Data has been updated.\n\n"+
//                    "doctor ID: "+ doctor.getId()+"\n\n"+
//                    "doctor Name: "+ doctor.getName()+"\n\n"+
//                    "doctor Specification: "+ doctor.getSpecification()+"\n\n"+
//                    "doctor's Patients: "+ doctor.getPatients()+"\n\n"
//            );
//    }
//    @GetMapping
//    @RequestMapping("/delete_doctor_by_id")
//    public ResponseEntity<String> Delete(Integer id){
//         doctorService.Delete(id);
//         if(doctorService.GetById(id)==null)
//             return ResponseEntity.ok("Data of the Doctor deleted");
//         else
//             return ResponseEntity.notFound().build();
//    }
//}
*/