package com.example.Eyada.Controllers;

import com.example.Eyada.Models.DTOs.PatientDto;
import com.example.Eyada.Services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.addPatient(patientDto));
    }
}
/*
@RestController
@RequestMapping("/Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> AddPatient(@RequestBody PatientDto dto){
        if(dto == null)
            return ResponseEntity.badRequest().body("Invalid Data entered");
        Patient patient = patientService.Add(dto);
        if(patient == null)
            return ResponseEntity.badRequest().body("Invalid Data entered");
        return ResponseEntity.ok("Patient "+ patient.getName() +" Added Successfully.");
    }

    @GetMapping
    @RequestMapping("/get_by_id")
    public ResponseEntity<String> GetById(@RequestBody Integer id){
        Patient patient = patientService.GetById(id);
        if(patient == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(
              "Id: "+ patient.getId()+"\n\n"+
                      "Name: "+patient.getName()+"\n\n"+
                      "Age: "+patient.getAge()+"\n\n"+
                    "Doctors: "+patient.getDoctors()
            );
    }

    @GetMapping
    @RequestMapping("/get_all")
    public ResponseEntity<List<Patient>> GetAll(){
        List<Patient> patients = patientService.GetAll();
//        if(patients == null)
//            return ResponseEntity.badRequest().body("There is no patients yet.");
//        else
            return ResponseEntity.ok(
                    patients
            );
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity<String> Update(@RequestBody PatientDto dto){
        Patient patient = patientService.Update(dto);
        if(patient == null)
            return ResponseEntity.badRequest().body("Invalid data");
        else
            return ResponseEntity.ok("Patient Data has been updated.\n\n"+
                    "Patient ID: "+ patient.getId()+"\n\n"+
                    "Patient Name: "+ patient.getName()+"\n\n"+
                    "Patient Age: "+ patient.getAge()+"\n\n"
            );
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public ResponseEntity<String> Delete(@RequestBody Integer id){
         patientService.Delete(id);
         Patient patient = patientService.GetById(id);
         if(patient ==null)
             return ResponseEntity.ok("Patient has been deleted.");
         else
             return ResponseEntity.badRequest().body("Patient with id "+id+" not found.");
    }
}
*/
