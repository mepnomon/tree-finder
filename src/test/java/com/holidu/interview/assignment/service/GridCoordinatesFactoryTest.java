package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.GridCoordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GridCoordinatesFactoryTest {

    private GridCoordinatesFactory gridCoordinatesFactory;

    @BeforeEach
    public  void before(){
        gridCoordinatesFactory = new GridCoordinatesFactory();
    }

    @Test
    public void test_get_tree_grid_with_same_offset_0_passes_if_values_match() {

        double x = 0, y = 0, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(-5, 5, -5, 5);

        GridCoordinates actualResult = gridCoordinatesFactory.build(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_same_offset_5_passes_if_values_match() {

        double x = 5, y = 5, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(0, 10, 0, 10);

        GridCoordinates actualResult = gridCoordinatesFactory.build(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_match() {

        double x = 5, y = 3, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(-2, 8, 0, 10);

        GridCoordinates actualResult = gridCoordinatesFactory.build(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_do_not_match() {

        double x = 5, y = 3, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(2, 3, 3, 3);

        GridCoordinates actualResult = gridCoordinatesFactory.build(x,y,radius);

        assertNotEquals(expectedResult, actualResult);
    }
}