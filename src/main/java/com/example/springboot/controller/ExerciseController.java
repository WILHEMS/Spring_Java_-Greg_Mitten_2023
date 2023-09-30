package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ExerciseController {
    private Integer timeOfDay;
        @GetMapping(value = "/info")
        public ResponseEntity<String> index() {

            return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("/random")
    ResponseEntity<String> randomTries(){

        if (new Random().nextBoolean()) {
            return new ResponseEntity<>(
                    "False choice",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                "True Choice" ,
                HttpStatus.OK);
    }

}
