package com.holidu.interview.assignment.models;

import java.util.Objects;

public class GridCoordinates {

    private double bottom, top, left, right;

    public GridCoordinates(double bottom, double top, double left, double right) {
        this.bottom = bottom;
        this.top = top;
        this.left = left;
        this.right = right;
    }


    public double getBottom() {
        return bottom;
    }

    public double getTop() {
        return top;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
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
    public String toString() {
        return "GridCoordinates{" +
                "bottom=" + bottom +
                ", top=" + top +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottom, top, left, right);
    }
}
