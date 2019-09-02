package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.GridCoordinates;
import org.springframework.stereotype.Service;

@Service
public class GridCoordinatesFactory {

    public GridCoordinates build(double x, double y, double radius) {

        double bottom = y - radius;
        double top = y + radius;
        double left = x - radius;
        double right = x + radius;

        return new GridCoordinates(bottom, top, left, right);
    }
}