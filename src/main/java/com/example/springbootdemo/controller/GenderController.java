package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Gender;
import com.example.springbootdemo.response.Result;
import com.example.springbootdemo.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/genders", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenderController {

    @Autowired
    GenderService genderService;

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGenders() {
        Result<List<Gender>> genderList = genderService.findAllGender();
        return new ResponseEntity<>(genderList.getData(), HttpStatus.valueOf(genderList.getCode()));
    }

//    @PreAuthorize("hasAnyRole('Admin','User')")
    @GetMapping("/{genderId}")
    public ResponseEntity<Gender> getGenderById(@PathVariable int genderId) throws Exception {
        Result<Gender> genderList = genderService.findGenderById(genderId);
        return new ResponseEntity<>(genderList.getData(), HttpStatus.valueOf(genderList.getCode()));
    }

//    @PreAuthorize("hasAnyRole('Admin','User')")
    @PostMapping
    public ResponseEntity<Gender> addGender(@RequestBody(required = true) Gender gender) throws Exception {
        Result<Gender> genderResult = genderService.addGender(gender);
        return new ResponseEntity(genderResult.getData(), HttpStatus.valueOf(genderResult.getCode()));
    }

//    @PreAuthorize("hasAnyRole('Admin','User')")
    @PutMapping("/{genderId}")
    public ResponseEntity<Gender> updateGender(@PathVariable int genderId, @RequestBody(required = true) Gender gender) throws Exception {
        Result<Gender> genderResult = genderService.updateGender(genderId, gender);
        return new ResponseEntity(genderResult.getData(), HttpStatus.valueOf(genderResult.getCode()));
    }

//    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/{genderId}")
    public ResponseEntity<Result<String>> deleteGenderById(@PathVariable int genderId) throws Exception {
        Result<String> result = genderService.deleteGender(genderId);
//        return new ResponseEntity<>(new ResponseMessage(result.getMessage()), HttpStatus.valueOf(result.getCode()));
        return new ResponseEntity(result, HttpStatus.valueOf(result.getCode()));
    }

}
