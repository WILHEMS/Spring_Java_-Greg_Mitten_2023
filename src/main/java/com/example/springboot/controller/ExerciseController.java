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

    //The first controller - Postman, requests
    //Exercise 1
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
    @GetMapping("/helloResponse")
    public ResponseEntity<String> helloWorldResponse(){
        return ResponseEntity.ok().body("Hello World");
    }
    //Exercise 2
    @GetMapping("/helloGreeting")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok().body("Good Afternoon");
    }

    //Exercise 3
    @GetMapping(value = "/info")
    public ResponseEntity<String> index() {

        return new ResponseEntity<>(HttpStatus.OK);

    }
    //Exercise 4
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
