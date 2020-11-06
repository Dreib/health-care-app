package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.User;
import org.fasttrackit.healthcareapp.service.DoctorService;
import org.fasttrackit.healthcareapp.service.UserService;
import org.fasttrackit.healthcareapp.transfer.SaveUserRequest;
import org.fasttrackit.healthcareapp.transfer.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final UserService userService;

    @Autowired
    public DoctorController(UserService userService) {
        this.userService = userService;
    }

}
