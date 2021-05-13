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
import java.util.List;

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

    @GetMapping("/{personcnp}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable long personcnp) {
        Appointment appointment = appointmentService.getAppointment(personcnp);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping
    public List<Appointment> getAppointments(GetAppointmentRequest getAppointmentRequest) {
        List appointments = appointmentService.getAppointments(getAppointmentRequest);
        return appointments;
    }

    @PutMapping("/{id}")
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
