package com.controllers;

import com.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private IService iService;

    @GetMapping("")
    public ResponseEntity<?> getData() {
        return ResponseEntity.status(HttpStatus.OK).body(iService.getAll());
    }
}
