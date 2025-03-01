//package com.example.Eyada.Controllers;
//
//import com.example.Eyada.Models.DTOs.DoctorDTO;
//import com.example.Eyada.Models.DTOs.SpecificationDTO;
//import com.example.Eyada.Models.Entities.Doctor;
//import com.example.Eyada.Models.Entities.Specification;
//import com.example.Eyada.Services.DoctorService;
//import com.example.Eyada.Services.SpecificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/specification")
//public class SpecificationController {
//    @Autowired
//    private SpecificationService specificationService;
//
//    @PostMapping
//    @RequestMapping("/add_specification")
//    public ResponseEntity<String> Add(@RequestBody SpecificationDTO dto){
//        if(dto != null) {
//
//            Specification specification = specificationService.Add(dto);
//            return ResponseEntity.ok().body(specification.getId()+"  "+specification.getTitle());        }
//        else{
//           return ResponseEntity.badRequest().body("invalid data request");
//
//        }
//    }
//
//    @GetMapping
//    @RequestMapping("/get_specification_by_id")
//    public ResponseEntity<Specification> GetById(@RequestBody Integer id){
//       Specification specification = specificationService.GetById(id);
//       if(specification !=  null)
//           return ResponseEntity.ok(specification);
//       else
//           return null;
//    }
//
//    @GetMapping
//    @RequestMapping("/get_specifications")
//    public ResponseEntity<List<Specification>> GetAll(){
//        List<Specification> specifications= specificationService.GetAll();
//        return ResponseEntity.ok(specifications);
//    }
//
//    @GetMapping
//    @RequestMapping("/update_specification")
//    public ResponseEntity<String> Update(@RequestBody SpecificationDTO dto){
//        if(dto != null) {
//            specificationService.Update(dto);
//            return ResponseEntity.ok("Entity updated.");
//        }
//        else
//            return ResponseEntity.badRequest().body("invalid data") ;
//    }
//
//    @GetMapping
//    @RequestMapping("/delete_specification")
//    public ResponseEntity<String> Delete(@RequestBody Integer id){
//        Specification specification = specificationService.GetById(id);
//        if(specification != null) {
//            specificationService.Delete(id);
//            return ResponseEntity.ok("Entity Deleted.");
//        }
//        else
//            return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping
//    @RequestMapping("/delete")
//    public ResponseEntity<String> DeleteAll(){
//        specificationService.DeleteAll();
//        return ResponseEntity.ok("All Deleted.");
//    }
//
//
//
//
//}
