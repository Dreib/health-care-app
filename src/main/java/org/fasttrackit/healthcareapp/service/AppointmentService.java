package org.fasttrackit.healthcareapp.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.domain.History;
import org.fasttrackit.healthcareapp.persistence.AppointmentRepository;
import org.fasttrackit.healthcareapp.persistence.HistoryRepository;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.appointment.SaveAppointmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(SaveAppointmentRequest request) {
        LOGGER.info("Adding a new appointment {}", request);

        Appointment appointment = new Appointment();
        appointment.setData(request.getData());
        appointment.setOra(request.getOra());
        appointment.setObservatie(request.getObservatie());

        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(long id) {
        LOGGER.info("Retrieving appointment {}", id);

        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment " + id + " does not exist."));
    }

    public Page<Appointment> getAppointmentByPerson(GetAppointmentRequest request, Pageable pageable) {
        LOGGER.info("Retrieving appointment for {}", request);
        return appointmentRepository.findByPerson_cnp(request.getPerson_cnp(), pageable);
    }

    public Page<Appointment> getAppointments(GetAppointmentRequest request, Pageable pageable) {
        LOGGER.info("Retrieving appointments {}", request);
        return appointmentRepository.findByDate(request.getData(), pageable);
    }

    public Appointment updateAppointment(GetAppointmentRequest request, long id) {
        LOGGER.info("Updating appointment {}", request);
        Appointment existingAppointment = getAppointment(id);

        BeanUtils.copyProperties(request, existingAppointment);

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(long id) {
        LOGGER.info("Removing appointment {}", id);
        appointmentRepository.deleteById(id);
    }

}
