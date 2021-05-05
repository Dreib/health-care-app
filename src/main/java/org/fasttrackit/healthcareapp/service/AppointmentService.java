package org.fasttrackit.healthcareapp.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.persistence.AppointmentRepository;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.appointment.SaveAppointmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(SaveAppointmentRequest request) {
        LOGGER.info("Adding appointment {}", request);

        Appointment appointment = new Appointment();
        appointment.setId(request.getId());
        appointment.setPersoncnp(request.getPersoncnp());
        appointment.setData(request.getData());
        appointment.setOra(request.getOra());
        appointment.setObservatie(request.getObservatie());

        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(long personcnp) {
        LOGGER.info("Retrieving appointment for {}", personcnp);

        Appointment appointmentFound = new Appointment();

        try {
            appointmentFound = appointmentRepository.findAppointmentByPersoncnp(personcnp);
        } catch (Exception e) {
            new ResourceNotFoundException("Appointment " + personcnp + " does not exist.");
        }

        return appointmentFound;
    }

    public List<Appointment> getAppointments(GetAppointmentRequest request) {
        LOGGER.info("Retrieving appointments {}", request);
        return appointmentRepository.findAll();
    }

    public Appointment updateAppointment(SaveAppointmentRequest request) {
        LOGGER.info("Updating appointment for {}: {}", request.getPersoncnp(), request);

        Appointment existingAppointment = getAppointment(request.getPersoncnp());

        BeanUtils.copyProperties(request, existingAppointment);

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(long id) {
        LOGGER.info("Removing appointment {}", id);
        appointmentRepository.deleteById(id);
    }

}
