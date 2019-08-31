package com.holidu.interview.assignment.service;

public class TreeFinder {


    public GridCoordinates getTreeGrid(int x, int y, int radius) {

        int bottom = y - radius;
        int top = y + radius;
        int left = x - radius;
        int right = x + radius;
        return new GridCoordinates(bottom, top, left, right);
    }

}
