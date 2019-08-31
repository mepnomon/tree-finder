package com.holidu.interview.assignment.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TreeFinderTest {

    private static TreeFinder treeFinder;

    @BeforeAll
    public static void before(){
        treeFinder = new TreeFinder();
    }

    @Test
    public void test_get_tree_grid_passes_if_values_matched() {
        int x = 0, y = 0, radius = 5;
        // order bottom, top, left, right
        int[] expectedResult = {-5, 5, -5, 5};
        int[] actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertArrayEquals(expectedResult, actualResult);
    }
}