package com.example.Eyada.Models.DTOs;

import com.example.Eyada.Models.Entities.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Integer Appointment_Id;

    private List<DayOfWeek> dayOfWeek;

    private Time time;

    private Long DoctorId;

    private String DoctorName;

    public static AppointmentDTO toDTO(Appointment entity){
        return AppointmentDTO
                .builder()
                .Appointment_Id(entity.getAppointmentId())
                .DoctorId(entity.getDoctor().getId())
                .DoctorName(entity.getDoctor().getName())
                .dayOfWeek(entity.getDayOfWeek())
                .time(entity.getTime())
                .build();
    }
}
