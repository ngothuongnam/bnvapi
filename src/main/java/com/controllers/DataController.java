package com.controllers;

import com.models.Data;
import com.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private IService<Data> iService;

    @GetMapping("")
    public ResponseEntity<?> getData() {
        return ResponseEntity.status(HttpStatus.OK).body(iService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<?> insertData(@RequestBody Data data){
        int result = iService.insertTable(data);
        if(result == 1){
            return ResponseEntity.status(HttpStatus.OK).body("Successful");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail");
        }
    }
}
