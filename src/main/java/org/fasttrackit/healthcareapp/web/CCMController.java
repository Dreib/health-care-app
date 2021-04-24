package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.CCM;
import org.fasttrackit.healthcareapp.service.CCMService;
import org.fasttrackit.healthcareapp.transfer.ccm.SaveCCMRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/ccm")
public class CCMController {

    private final CCMService ccmService;

    @Autowired
    public CCMController(CCMService ccmService) {
        this.ccmService = ccmService;
    }

    @PostMapping
    public ResponseEntity<CCM> createCCM(@RequestBody @Valid SaveCCMRequest request) {
        CCM ccm = ccmService.createCCM(request);
        return new ResponseEntity<>(ccm, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CCM> getCCM(@PathVariable long id) {
        CCM ccm = ccmService.getCCM(id);
        return ResponseEntity.ok(ccm);
    }

    @PutMapping
    public ResponseEntity<CCM> updateCCM(@RequestBody @Valid SaveCCMRequest request) {
        CCM ccm = ccmService.updateCCM(request);
        return ResponseEntity.ok(ccm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCCM(@PathVariable long id) {
        ccmService.deleteCCM(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
