package com.example.Eyada.Controllers;

import com.example.Eyada.Models.DTOs.AppointmentDto;
import com.example.Eyada.Models.DTOs.AppointmentRequestDto;
import com.example.Eyada.Models.DTOs.AppointmentResponseDto;
import com.example.Eyada.Services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<AppointmentResponseDto> bookAppointment(@RequestBody AppointmentRequestDto requestDto) {
        return ResponseEntity.ok(appointmentService.bookAppointment(requestDto));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponseDto>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }

    @GetMapping
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentDto));
    }

    @GetMapping
    public ResponseEntity<Boolean> deleteAppointment(@RequestParam Long appointmentId){
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentId));
    }
}
