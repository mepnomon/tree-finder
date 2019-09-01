package com.holidu.interview.assignment.service;

public class TreeFinder {


    public GridCoordinates getTreeGrid(double x, double y, double radiusInMeters) {


        // THIS CALCULATION IS CRAP

        double bottom = y - radiusInMeters;
        double top = y + radiusInMeters;
        double left = x - radiusInMeters;
        double right = x + radiusInMeters;
        return new GridCoordinates(bottom, top, left, right);
    }
}
