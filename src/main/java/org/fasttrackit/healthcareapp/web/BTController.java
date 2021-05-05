package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.BT;
import org.fasttrackit.healthcareapp.service.BTService;
import org.fasttrackit.healthcareapp.transfer.bt.GetBTRequest;
import org.fasttrackit.healthcareapp.transfer.bt.SaveBTRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bt")
public class BTController {

    private final BTService btService;

    @Autowired
    public BTController(BTService btService) {
        this.btService = btService;
    }

    @PostMapping
    public ResponseEntity<BT> createBT(@RequestBody @Valid SaveBTRequest request) {
        BT bt = btService.createBT(request);
        return new ResponseEntity<>(bt, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BT> getBT(@PathVariable long id) {
        BT bt = btService.getBT(id);
        return ResponseEntity.ok(bt);
    }

    @GetMapping
    public List<BT> getBilete(@RequestBody(required = false) @Valid GetBTRequest request) {
        List trimiteri = btService.getBilete(request);
        return trimiteri;
    }

    @PutMapping
    public ResponseEntity<BT> updateBT(@RequestBody @Valid SaveBTRequest request) {
        BT bt = btService.updateBT(request);
        return ResponseEntity.ok(bt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBT(@PathVariable long id) {
        btService.deleteBT(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
