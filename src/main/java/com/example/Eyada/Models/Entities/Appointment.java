package com.example.Eyada.Models.Entities;

import com.example.Eyada.Models.DTOs.AppointmentDTO;
import jakarta.persistence.*;
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
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Appointment_Id")
    private Integer AppointmentId;

//    textual enum name, each day-of-week has an int value.
//    The int value from 1 (Monday) to 7 (Sunday)
    private List<DayOfWeek> dayOfWeek;

    private Time time;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public static Appointment toEntit(AppointmentDTO dto){
        return Appointment.builder()
                .AppointmentId(dto.getAppointment_Id())
                .dayOfWeek(dto.getDayOfWeek())
                .time(dto.getTime())
                .doctor((Doctor) User
                        .builder()
                        .Id(dto.getDoctorId())
                        .build())
                .build();


    }
}
