package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    Meal updateMealPriceByName(String name, double price);
    Meal updateMealByName(double price);
    Meal deleteMealsByPriceGreaterThan(double price);
    Meal deleteMealByName(String name);
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsSummerMeal(boolean isSummerMeal);

    List<Meal> findMealsByPriceGreaterThanAndPriceLessThan(double min, double max);
}
