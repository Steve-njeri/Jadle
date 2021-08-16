package DAO;

import models.FoodType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oFoodTypeDaoTest {
    private Sql2oFoodTypeDao foodTypeDao;
    private Sql2oRestaurantDao restaurantDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodTypeDao = new Sql2oFoodTypeDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingFoodSetsId() throws Exception {
        FoodType testFoodType = setupNewFoodType();
        int originalFoodTypeId = testFoodType.getId();
        foodTypeDao.add(testFoodType);
        assertNotEquals(originalFoodTypeId,testFoodType.getId());
    }


    @Test
    public void addedFoodTypesAreReturnedFromGetAll() throws Exception {
        FoodType testFoodType = setupNewFoodType();
        foodTypeDao.add(testFoodType);
        assertEquals(1, foodTypeDao.getAll().size());
    }

    @Test
    public void noFoodTypesReturnsEmptyList() throws Exception {
        assertEquals(0, foodTypeDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodType() throws Exception {
        FoodType foodType = setupNewFoodType();
        foodTypeDao.add(foodType);
        foodTypeDao.deleteById(foodType.getId());
        assertEquals(0, foodTypeDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        FoodType testFoodType = setupNewFoodType();
        FoodType otherFoodType = setupNewFoodType();
        foodTypeDao.clearAll();
        assertEquals(0, foodTypeDao.getAll().size());
    }

    // helpers

    public FoodType setupNewFoodType(){
        return new FoodType("Sushi");
    }
}
