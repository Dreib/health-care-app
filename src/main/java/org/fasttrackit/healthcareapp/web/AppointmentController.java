package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.domain.Person;
import org.fasttrackit.healthcareapp.service.AppointmentService;
import org.fasttrackit.healthcareapp.transfer.appointment.AppointmentResponse;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.appointment.SaveAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.person.SavePersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable long id) {
        Appointment appointment = appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Appointment>> getAppointmentByPerson(@RequestBody @Valid GetAppointmentRequest request, Pageable pageable) {
        Page<Appointment> appointments = appointmentService.getAppointmentByPerson(request, pageable);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Appointment>> getAppointments(@RequestBody @Valid GetAppointmentRequest request, Pageable pageable) {
        Page<Appointment> appointments = appointmentService.getAppointments(request, pageable);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Appointment> updatePerson(@PathVariable long id, @RequestBody @Valid GetAppointmentRequest request) {
        Appointment appointment = appointmentService.updateAppointment(request, id);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePerson(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
