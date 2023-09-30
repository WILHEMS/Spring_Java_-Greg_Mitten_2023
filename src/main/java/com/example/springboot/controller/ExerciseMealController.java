package com.example.springboot.controller;

import com.example.springboot.dao.MealDao;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseMealController {
    private MealService mealService;
    private MealDao mealDao;

    @Autowired
    public ExerciseMealController(MealService mealService) {
        this.mealService = mealService;
    }

    //Controller path variables, request params, returning objects
    //Exercise 1
    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }
    //Exercise 2
    @GetMapping("/meal/{name}")
    public ResponseEntity<Meal> getMeal(@PathVariable String name) {
        mealService.getMeal(name);
        return ResponseEntity.ok().build();
    }
    //Exercise 3
    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<Meal> getMealPhrase(@PathVariable String phrase) {
        mealService.getDescription(phrase);
        return ResponseEntity.ok().build();
    }
    //Exercise 4
    @GetMapping("meal/price")
    public ResponseEntity<List<Meal>> getMealsByPriceRange(@RequestParam("min") double min, @RequestParam("max") double max){

        return new ResponseEntity<>(mealDao.findMealsByPriceGreaterThanAndPriceLessThan(min, max), HttpStatus.OK);
    }

}
