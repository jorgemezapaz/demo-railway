package com.example.demo.controller;

import com.example.demo.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {
  private final DataService service;

  @GetMapping("/{id}")
  public ResponseEntity getById(@PathVariable("id") Long id){
    return new ResponseEntity(service.getById(id), HttpStatus.OK);
  }
}
