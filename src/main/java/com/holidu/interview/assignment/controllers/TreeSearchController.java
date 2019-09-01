package com.holidu.interview.assignment.controllers;

import org.springframework.web.client.RestTemplate;

public class TreeSearchController {

    public static void main(String[] args) {
        getTrees();
    }

    private static void getTrees() {
        String requestUri = "https://data.cityofnewyork.us/resource/uvpi-gqnh.json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(requestUri, String.class);

        System.out.println(result);
    }

    private static void getTreesForOffset() {
        String requestUri = "";
    }
}
