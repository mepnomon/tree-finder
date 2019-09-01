package com.holidu.interview.assignment.models;

import com.holidu.interview.assignment.util.UnitConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchParametersTest {

    private SearchParameters searchParameters;

    @Test
    public void test_get_meters_in_feet_convert_1_meter_to_feet() {

        double radiusInMeters = 1;
        searchParameters = new SearchParameters(1.0, 1.0, radiusInMeters);
        double expectedResult = 3.28084;
        double actualResult = searchParameters.getRadiusInFeet();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test_convert_2_meters_to_feet() {

        double radiusInMeters = 2;
        searchParameters = new SearchParameters(1.0, 1.0, radiusInMeters);
        double expectedResult = 6.56168;
        double actualResult = searchParameters.getRadiusInFeet();
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_convert_decimal_meters_to_feet() {
        double radiusInMeters = 1.5;
        searchParameters = new SearchParameters(1.0, 1.0, radiusInMeters);
        double expectedResult = 4.92126;
        double actualResult = searchParameters.getRadiusInFeet();
        assertEquals(actualResult, expectedResult);
    }
}