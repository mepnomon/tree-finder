package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.GridCoordinates;
import com.holidu.interview.assignment.util.UnitConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

class TreeFinderTest {

    private TreeFinder treeFinder;
    private UnitConverter unitConverterMock;

    @BeforeEach
    public  void before(){
        unitConverterMock = Mockito.mock(UnitConverter.class);
        treeFinder = new TreeFinder(unitConverterMock);
    }

    @Test
    public void test_get_tree_grid_with_same_offset_0_passes_if_values_match() {

        double x = 0, y = 0, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(-5, 5, -5, 5);
        when(unitConverterMock.convertToUSFeet(radius)).thenReturn(radius);

        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_same_offset_5_passes_if_values_match() {

        double x = 5, y = 5, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(0, 10, 0, 10);
        when(unitConverterMock.convertToUSFeet(radius)).thenReturn(radius);

        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_match() {

        double x = 5, y = 3, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(-2, 8, 0, 10);
        when(unitConverterMock.convertToUSFeet(radius)).thenReturn(radius);

        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_get_tree_grid_with_different_offset_5_3_passes_if_values_do_not_match() {

        double x = 5, y = 3, radius = 5;
        GridCoordinates expectedResult = new GridCoordinates(2, 3, 3, 3);
        when(unitConverterMock.convertToUSFeet(radius)).thenReturn(radius);

        GridCoordinates actualResult = treeFinder.getTreeGrid(x,y,radius);

        assertNotEquals(expectedResult, actualResult);
    }
}