package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.GridCoordinates;
import com.holidu.interview.assignment.models.SearchParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TreeAPIRequest {

    GridCoordinatesFactory gridCoordinatesFactory;
    private final String BASE_URL = "https://data.cityofnewyork.us/resource/uvpi-gqnh.json?";


    public TreeAPIRequest(GridCoordinatesFactory gridCoordinatesFactory) {
        this.gridCoordinatesFactory = gridCoordinatesFactory;
    }


    String makeRequest(SearchParameters parameters) {

        RestTemplate restTemplate = new RestTemplate();
        String querySubString = buildSearchTreeQuery(parameters);
        String query = BASE_URL + querySubString;

        return restTemplate.getForObject(query, String.class);
    }

    String buildSearchTreeQuery(SearchParameters parameters) {

        GridCoordinates coords = gridCoordinatesFactory.build(parameters.getX(), parameters.getY(), parameters.getRadiusInFeet());
        String query = "$select=spc_common&$where=x_sp between " + coords.getLeft() + " and " + coords.getRight()
                + " and y_sp between " + coords.getBottom() + " and " + coords.getTop();
        return query;
    }
}