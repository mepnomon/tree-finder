package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.util.UnitConverter;

public class TreeFinder {



    UnitConverter unitConverter = new UnitConverter();

    public GridCoordinates getTreeGrid(double x, double y, double radiusInMeters) {

        double radiusInFeet = unitConverter.convertToUSFeet(radiusInMeters);

        double bottom = y - radiusInFeet;
        double top = y + radiusInFeet;
        double left = x - radiusInFeet;
        double right = x + radiusInFeet;

        return new GridCoordinates(bottom, top, left, right);
    }
}
