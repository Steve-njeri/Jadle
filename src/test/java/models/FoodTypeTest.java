package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTypeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        FoodType testFoodType = setupFoodType();
        assertEquals("dessert", testFoodType.getName());
    }

    @Test
    public void setName() {
        FoodType testFoodType = setupFoodType();
        testFoodType.setName("breakfast");
        assertNotEquals("dessert", testFoodType.getName());
    }

    @Test
    public void setId() {
        FoodType testFoodType = setupFoodType();
        testFoodType.setId(5);
        assertEquals(5, testFoodType.getId());
    }

    // helper
    public FoodType setupFoodType(){
        return new FoodType("dessert");
    }
}
