package org.fasttrackit.healthcareapp.service;

import org.fasttrackit.healthcareapp.domain.CCM;
import org.fasttrackit.healthcareapp.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.persistence.CCMRepository;
import org.fasttrackit.healthcareapp.transfer.ccm.SaveCCMRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCMService {

    private final CCMRepository ccmRepository;

    @Autowired
    public CCMService(CCMRepository ccmRepository) {
        this.ccmRepository = ccmRepository;
    }

    public CCM createCCM(SaveCCMRequest request) {
        CCM ccm = new CCM();

        ccm.setCnp(request.getCnp());
        ccm.setNumar(request.getNumar());
        ccm.setSerie(request.getSerie());
        ccm.setV_date_start(request.getV_date_start());
        ccm.setV_date_end(request.getV_date_end());

        return ccmRepository.save(ccm);
    }

    public CCM getCCM(long id) {
        return ccmRepository.findById(id)
                //lambda expression
                .orElseThrow(() -> new ResourceNotFoundException("User " + id + " does not exist."));
    }

    public CCM updateCCM(SaveCCMRequest request) {
        CCM existingCCM = getCCM(request.getId());

        BeanUtils.copyProperties(request, existingCCM);

        return ccmRepository.save(existingCCM);
    }

    public void deleteCCM(long id) {
        ccmRepository.deleteById(id);
    }

}
