package com.holidu.interview.assignment.models;

public class SearchParameters {

    private final double x;
    private final double y;
    private final double radiusInMeters;

    private final static double METERS_TO_US_FEET = 3.28084;

    public SearchParameters(double x, double y, double radiusInMeters) {
        this.x = x;
        this.y = y;
        this.radiusInMeters = radiusInMeters;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadiusInFeet() {
        return  radiusInMeters * METERS_TO_US_FEET;
    }

}
