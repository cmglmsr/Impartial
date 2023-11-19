package com.site.news.controllers;

import com.site.news.model.BaseEntity;
import com.site.news.services.BaseEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    private final BaseEntityService baseEntityService;

    public RegisterController(BaseEntityService baseEntityService) {
        this.baseEntityService = baseEntityService;
    }

    @PostMapping("/home/register")
    public ResponseEntity<?> register(@RequestBody BaseEntity baseEntity){
        if (baseEntity.getUsername() != null && baseEntity.getPassword() != null){
            if (baseEntityService.loadUserByUsername(baseEntity.getUsername()) == null){
                baseEntityService.save(baseEntity);
                return new ResponseEntity<>("Created.", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Duplicate user.", HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>("Fields are null.", HttpStatus.OK);        }
    }
}
