package com.holidu.interview.assignment.util;

public class UnitConverter {

    private final double METERS_TO_US_FEET = 3.28084;

    public double convertToUSFeet(double radiusInMeters) {

        return radiusInMeters * METERS_TO_US_FEET;
    }
}
