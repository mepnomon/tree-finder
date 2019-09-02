package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTesterTest {


    CircleTester circle;
    SearchParameters params;
    @Test
    public void test_if_point_is_inside_circle_passes_if_false() {

        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,1,9));
    }

    @Test
    public void second_test_if_point_is_inside_circle_passes_if_false() {

        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,1,10));
    }

    @Test
    public void test_if_point_is_inside_circle_passes_if_true(){
        params = new SearchParameters(5,5,5);
        circle = new CircleTester();
        assertTrue(circle.checkIfInsideCircle(params,6,6));
    }

    @Test
    public void second_test_if_point_is_inside_circle_passes_if_true() {
        params = new SearchParameters(5,5,5);
        circle = new CircleTester();
        assertTrue(circle.checkIfInsideCircle(params,5,0.1));
    }

}