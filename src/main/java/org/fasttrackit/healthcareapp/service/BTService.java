package org.fasttrackit.healthcareapp.service;

import org.fasttrackit.healthcareapp.domain.BT;
import org.fasttrackit.healthcareapp.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.persistence.BTRepository;
import org.fasttrackit.healthcareapp.transfer.appointment.GetAppointmentRequest;
import org.fasttrackit.healthcareapp.transfer.bt.GetBTRequest;
import org.fasttrackit.healthcareapp.transfer.bt.SaveBTRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BTService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BTService.class);

    private final BTRepository btRepository;

    @Autowired
    public BTService(BTRepository btRepository) {
        this.btRepository = btRepository;
    }

    public BT createBT(SaveBTRequest request) {
        BT bt = new BT();

        bt.setId(request.getId());
        bt.setData_trimitere(request.getData_trimitere());
        bt.setJudet(request.getJudet());
        bt.setLocalitate(request.getLocalitate());
        bt.setUnitate_sanitara(request.getUnitate_sanitara());
        bt.setCnp(request.getCnp());
        bt.setCatre(request.getCatre());
        bt.setDiagnostic_prezumtiv(request.getDiagnostic_prezumtiv());
        bt.setMotivul_trimiterii(request.getMotivul_trimiterii());
        bt.setInvestigatii_tratamente(request.getInvestigatii_tratamente());

        return btRepository.save(bt);
    }

    public BT getBT(long id) {
        return btRepository.findById(id)
                //lambda expression
                .orElseThrow(() -> new ResourceNotFoundException("BT " + id + " does not exist."));
    }

    public List<BT> getBilete(GetBTRequest request) {
        LOGGER.info("Retrieving bt {}", request);
        return btRepository.findAll();
    }

    public BT updateBT(SaveBTRequest request) {
        BT existingBT = getBT(request.getId());

        BeanUtils.copyProperties(request, existingBT);

        return btRepository.save(existingBT);
    }

    public void deleteBT(long id) {
        btRepository.deleteById(id);
    }

}
