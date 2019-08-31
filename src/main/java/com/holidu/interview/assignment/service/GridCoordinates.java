package com.holidu.interview.assignment.service;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCoordinates that = (GridCoordinates) o;
        return bottom == that.bottom &&
                top == that.top &&
                left == that.left &&
                right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottom, top, left, right);
    }
}
