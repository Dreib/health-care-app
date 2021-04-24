package org.fasttrackit.healthcareapp.service;

import org.fasttrackit.healthcareapp.domain.BT;
import org.fasttrackit.healthcareapp.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.persistence.BTRepository;
import org.fasttrackit.healthcareapp.transfer.bt.SaveBTRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BTService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(BTService.class);

    private final BTRepository btRepository;

    @Autowired
    public BTService(BTRepository btRepository) {
        this.btRepository = btRepository;
    }

    public BT createBT(SaveBTRequest request) {
        BT bt = new BT();

        bt.setCnp(request.getCnp());
        bt.setCatre(request.getCatre());
        bt.setJudet(request.getJudet());
        bt.setLocalitate(request.getLocalitate());
        bt.setData_trimitere(request.getData_trimitere());
        bt.setDiagnostic_prezumtiv(request.getDiagnostic_prezumtiv());
        bt.setMotivul_trimiterii(request.getMotivul_trimiterii());
        bt.setUnitate_sanitara(request.getUnitate_sanitara());
        bt.setInvestigatii_tratamente(request.getInvestigatii_tratamente());

        return btRepository.save(bt);
    }

    public BT getBT(long id) {
        /*BT btFound = new BT();

        try {
            btFound = btRepository.findById(bt_id);
        } catch(Exception e) {
            new ResourceNotFoundException("Biletul de trimitere cu id-ul " + bt_id + " nu exista.");
        }

        return btFound;*/

        return btRepository.findById(id)
                //lambda expression
                .orElseThrow(() -> new ResourceNotFoundException("User " + id + " does not exist."));
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
