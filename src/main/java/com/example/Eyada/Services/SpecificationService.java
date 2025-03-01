//package com.example.Eyada.Services;
//
//import com.example.Eyada.Models.DTOs.SpecificationDTO;
//import com.example.Eyada.Models.Entities.Specification;
//import com.example.Eyada.Repositories.SpecificationRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class SpecificationService {
//    @Autowired
//    private SpecificationRepo specificationRepo;
//
//    public Specification Add(SpecificationDTO specificationDTO){
//        Specification specification = Specification.builder()
//                .Title(specificationDTO.getTitle())
//                .build();
//        return specificationRepo.save(specification);
//    }
//
//    public Specification GetById(Integer id){
//        Optional<Specification> specification = specificationRepo.findById(id);
//        return specification.orElse(null);
//    }
//
//    public List<Specification> GetAll(){
//        return specificationRepo.findAll();
//    }
//
//    public Specification Update(SpecificationDTO specificationDTO){
//        Specification specification = Specification.builder().
//                Id(specificationDTO.getId()).
//                Title(specificationDTO.getTitle()).
//                build();
//        return specificationRepo.save(specification);
//     }
//
//     public void Delete(Integer id){
//        if(specificationRepo.existsById(id))
//            specificationRepo.deleteById(id);
//        return;
//     }
//
//     public void DeleteAll(){
//        specificationRepo.deleteAll();
//        return;
//     }
//}
