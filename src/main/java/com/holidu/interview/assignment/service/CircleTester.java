package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.springframework.stereotype.Service;

@Service
public class CircleTester {

    public boolean checkIfInsideCircle(SearchParameters param, double pointX, double pointY){

        return (pointX - param.getX()) * (pointX - param.getX()) +
                (pointY - param.getY()) * (pointY - param.getY())
                < param.getRadiusInFeet() * param.getRadiusInFeet();
    }
}
