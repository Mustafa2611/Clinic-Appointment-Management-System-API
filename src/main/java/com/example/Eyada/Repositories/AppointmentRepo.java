package com.example.Eyada.Repositories;

import com.example.Eyada.Models.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment , Integer> {
}
