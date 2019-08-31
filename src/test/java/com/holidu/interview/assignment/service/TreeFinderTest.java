package com.holidu.interview.assignment.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeFinderTest {

    private static TreeFinder treeFinder;

    @BeforeAll
    public static void before(){
        treeFinder = new TreeFinder();
    }

    @Test
    public void test_get_tree_grid_with_same_offset_0_passes_if_values_matched() {

        int x = 0, y = 0, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(-5, 5, -5, 5);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult.getBottom(), actualResult.getBottom());
        assertEquals(expectedResult.getTop(), actualResult.getTop());
        assertEquals(expectedResult.getLeft(), actualResult.getLeft());
        assertEquals(expectedResult.getRight(), actualResult.getRight());

    }

    @Test
    public void test_get_tree_grid_with_same_offset_5_passes_if_values_matched() {

        int x = 5, y = 5, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(0, 10, 0, 10);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult.getBottom(), actualResult.getBottom());
        assertEquals(expectedResult.getTop(), actualResult.getTop());
        assertEquals(expectedResult.getLeft(), actualResult.getLeft());
        assertEquals(expectedResult.getRight(), actualResult.getRight());
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_matched() {

        int x = 5, y = 3, radius = 5;

        GridCoordinates expectedResult = new GridCoordinates(-2, 8, 0, 10);
        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult.getBottom(), actualResult.getBottom());
        assertEquals(expectedResult.getTop(), actualResult.getTop());
        assertEquals(expectedResult.getLeft(), actualResult.getLeft());
        assertEquals(expectedResult.getRight(), actualResult.getRight());
   }


}