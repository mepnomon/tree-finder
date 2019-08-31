package com.holidu.interview.assignment.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridCoordinatesTest {

    private GridCoordinates gridCoordinates;

    @Test
    public void test_getters_passes_if_values_match(){
        int top = 5, bottom = 8, left = -19, right = 9;
        gridCoordinates = new GridCoordinates(bottom, top, left, right);
        assertEquals(gridCoordinates.getRight(), right);
        assertEquals(gridCoordinates.getLeft(), left);
        assertEquals(gridCoordinates.getTop(), top);
        assertEquals(gridCoordinates.getBottom(), bottom);
    }
}