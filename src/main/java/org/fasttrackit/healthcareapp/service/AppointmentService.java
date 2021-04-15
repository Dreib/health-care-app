package org.fasttrackit.healthcareapp.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.persistence.AppointmentRepository;
import org.fasttrackit.healthcareapp.transfer.appointment.AppointmentResponse;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.appointment.SaveAppointmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        appointment.setPersoncnp(request.getPersoncnp());
        appointment.setData(request.getData());
        appointment.setOra(request.getOra());
        appointment.setObservatie(request.getObservatie());

        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(long personcnp) {
        LOGGER.info("Retrieving appointment {}", personcnp);

        Appointment appointmentFound = new Appointment();

        try {
            appointmentFound = appointmentRepository.findAppointmentByPersoncnp(personcnp);
        } catch (Exception e) {
            new ResourceNotFoundException("Appointment " + personcnp + " does not exist.");
        }

        return appointmentFound;
    }

    public AppointmentResponse getAppointmentResponse(long personcnp) {
        Appointment appointment = getAppointment(personcnp);
        return mapAppointmentResponse(appointment);
    }

    public Page<AppointmentResponse> getAppointments(GetAppointmentRequest request, Pageable pageable) {
        LOGGER.info("Retrieving appointments: {}", request);

        Appointment exampleAppointment = new Appointment();
        exampleAppointment.setId(request.getId());
        exampleAppointment.setPersoncnp(request.getPersoncnp());
        exampleAppointment.setData(request.getData());
        exampleAppointment.setOra(request.getOra());
        exampleAppointment.setObservatie(request.getObservatie());

        Example<Appointment> example = Example.of(exampleAppointment,
                ExampleMatcher.matchingAny()
                    .withMatcher("personcnp", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                    .withMatcher("data", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                    .withMatcher("ora", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()));

        Page<Appointment> appointmentsPage = appointmentRepository.findAll(example, pageable);

        List<AppointmentResponse> appointmentDTOs = new ArrayList<>();

        for(Appointment appointment: appointmentsPage.getContent()) {
            AppointmentResponse appointmentResponse = mapAppointmentResponse(appointment);
            appointmentDTOs.add(appointmentResponse);
        }

        return new PageImpl<>(appointmentDTOs, pageable, appointmentsPage.getTotalElements());
    }

    public Appointment updateAppointment(SaveAppointmentRequest request) {
        LOGGER.info("Updating appointment for {}: {}", request.getPersoncnp(), request);

        Appointment existingAppointment = getAppointment(request.getPersoncnp());

        BeanUtils.copyProperties(request, existingAppointment);

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long personcnp) {
        LOGGER.info("Removing appointment for {}", personcnp);
        appointmentRepository.deleteAppointmentByPersoncnp(personcnp);
    }

    private AppointmentResponse mapAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setId(appointment.getId());
        appointmentResponse.setPersoncnp(appointment.getPersoncnp());
        appointmentResponse.setData(appointment.getData());
        appointmentResponse.setOra(appointment.getOra());
        appointmentResponse.setObservatie(appointment.getObservatie());

        return appointmentResponse;
    }

}
