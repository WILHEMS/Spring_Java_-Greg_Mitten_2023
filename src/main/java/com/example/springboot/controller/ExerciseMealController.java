package com.example.springboot.controller;

import com.example.springboot.dao.MealDao;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Character.getName;

@RestController
public class ExerciseMealController {
    private MealService mealService;
    private MealDao mealDao;
    private Meal meal;

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

    //Task 3

    //Request body, Post, autoserialization issues
    //Exercise 1
    @PostMapping(value = {"/meal"})
    public ResponseEntity<String > postMeal(@RequestBody Meal meal){

        mealService.addMeal(meal);

        return new ResponseEntity<>("Meal has been added successfully", HttpStatus.OK);
    }
    //Request body, Post, autoserialization issues
    //Exercise 2
    @PutMapping("/meal/{name}")
    public ResponseEntity<String> putMeal(@PathVariable String name, @RequestBody Meal meal) {
        meal.setName(name);
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated successfully");
    }

    //Exercise 3
    @DeleteMapping("/meal/{name}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable String name) {
        mealService.deleteMealName(name);
        return ResponseEntity.ok().build();
    }
    //Exercise 4
    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable double price) {
        mealService.deleteMealPrice(price);
        return ResponseEntity.ok().build();
    }
    //Exercise 5
    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody double price) {
        mealService.updateMealPrice(name,price);
        return ResponseEntity.ok("Meal updated successfully");
    }

}
