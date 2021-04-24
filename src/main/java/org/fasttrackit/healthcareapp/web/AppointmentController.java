package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.service.AppointmentService;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.appointment.SaveAppointmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/programari")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody @Valid SaveAppointmentRequest request) {
        Appointment appointment = appointmentService.addAppointment(request);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Appointment> getAppointment(@RequestBody @Valid GetAppointmentRequest request) {
        Appointment appointment = appointmentService.getAppointment(request.getPersoncnp());
        return ResponseEntity.ok(appointment);
    }

    @PutMapping
    public ResponseEntity<Appointment> updateAppointment(@RequestBody @Valid SaveAppointmentRequest request) {
        Appointment appointment = appointmentService.updateAppointment(request);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
