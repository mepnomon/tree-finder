package com.holidu.interview.assignment.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TreeFinderTest {

    private static TreeFinder treeFinder;

    @BeforeAll
    public static void before(){
        treeFinder = new TreeFinder();
    }

    @Test
    public void test_get_tree_grid_with_same_offset_0_passes_if_values_match() {

        double x = 0, y = 0, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(-5, 5, -5, 5);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_same_offset_5_passes_if_values_match() {

        double x = 5, y = 5, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(0, 10, 0, 10);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_match() {

        double x = 5, y = 3, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(-2, 8, 0, 10);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_do_not_match() {

        double x = 5, y = 3, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(2, 3, 3, 3);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertNotEquals(expectedResult, actualResult);
    }
}