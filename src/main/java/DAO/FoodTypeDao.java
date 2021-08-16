package DAO;

import models.FoodType;

import java.util.List;

public interface FoodTypeDao {
    //create
    void add(FoodType foodType);
    //void addFoodTypeToRestaurant(FoodType foodType, Restaurant restaurant);

    //read
    List<FoodType> getAll();
    // List<Restaurant> getAllRestaurantsForAFoodType(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
