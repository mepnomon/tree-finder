package com.holidu.interview.assignment.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitConverterTest {

    public static UnitConverter unitConverter;

    @BeforeAll
    public static void before() {
        unitConverter = new UnitConverter();
    }

    @Test
    public void test_convert_1_meter_to_feet() {

        double meters = 1;
        double expectedResult = 3.28084;
        double actualResult = unitConverter.convertToUSFeet(meters);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test_convert_2_meters_to_feet() {

        double meters = 2;
        double expectedResult = 6.56168;
        double actualResult = unitConverter.convertToUSFeet(meters);
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void test_convert_decimal_meters_to_feet() {
        double meters = 1.5;
        double expectedResult = 4.92126;
        double actualResult = unitConverter.convertToUSFeet(meters);
        assertEquals(actualResult, expectedResult);
    }

}