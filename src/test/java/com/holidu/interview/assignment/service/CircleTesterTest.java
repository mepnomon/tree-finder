package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTesterTest {


    CircleTester circle;
    SearchParameters params;

    @Test
    public void test_if_point_is_inside_circle_top_left_passes_if_false() {

        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,1,9));
    }


    @Test
    public void test_if_point_is_inside_circle_bottom_left_passes_if_false() {
        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,1,1));
    }

    @Test
    public void test_if_point_is_inside_circle_bottom_right_passes_if_false(){
        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,10,1));
    }

    @Test
    public void test_if_point_is_inside_circle_top_right_passes_if_fasle(){
        params = new SearchParameters(5,5,1);
        circle = new CircleTester();
        assertFalse(circle.checkIfInsideCircle(params,9,9));
    }

    @Test
    public void test_if_point_is_inside_circle_passes_if_true(){
        params = new SearchParameters(5,5,5);
        circle = new CircleTester();
        assertTrue(circle.checkIfInsideCircle(params,6,6));
    }

    @Test
    public void test_if_point_is_inside_circle_on_edge_passes_if_true() {
        params = new SearchParameters(5,5,5);
        circle = new CircleTester();
        assertTrue(circle.checkIfInsideCircle(params,5,0.1));
    }

}