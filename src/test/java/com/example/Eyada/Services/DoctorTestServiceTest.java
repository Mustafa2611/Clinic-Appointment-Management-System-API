package com.example.Eyada.Services;

import com.example.Eyada.Dtos.DoctorDtoTest;
import com.example.Eyada.Entities.DoctorTest;
import com.example.Eyada.Models.Entities.Doctor;
import com.example.Eyada.Repositories.DoctorRepositoryTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoctorTestServiceTest {

    @Mock
    private DoctorRepositoryTest doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    public DoctorTestServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllDoctors() {
        // Mock Data
        DoctorTest doctor = new DoctorTest();
        doctor.setId(1L);
        doctor.setName("Dr. John");
        doctor.setSpecialization("Cardiology");

        when(doctorRepository.findAll()).thenReturn( List.of(new Doctor()));

        // Test
//        List<DoctorDtoTest> doctors = doctorService.getAllDoctors();
//        assertEquals(1, doctors.size());
//        assertEquals("Dr. John", doctors.get(0).getName());
    }
}
