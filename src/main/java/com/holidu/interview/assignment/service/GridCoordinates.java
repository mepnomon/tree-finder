package com.holidu.interview.assignment.service;

public class GridCoordinates {

    private int bottom, top, left, right;

    public GridCoordinates(int bottom, int top, int left, int right) {
        this.bottom = bottom;
        this.top = top;
        this.left = left;
        this.right = right;
    }


    public int getBottom() {
        return bottom;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
