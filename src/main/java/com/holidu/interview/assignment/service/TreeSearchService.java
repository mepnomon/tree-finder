package com.holidu.interview.assignment.service;

import org.springframework.web.client.RestTemplate;

public class TreeSearchService {
    // data clumps
    public static void main(String[] args) {
        TreeSearchService treeSearchService = new TreeSearchService();
        //treeSearchService.getTrees();
    }

    private String baseUrl = "https://data.cityofnewyork.us/resource/uvpi-gqnh.json?";

    public void getTrees(double x, double y, double radiusInMeters) {

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.
        String result = restTemplate.getForObject(baseUrl, String.class);

        System.out.println(result);
    }

    private String buildSearchTreeQuery() {
    //$select=spc_common&$where=x_sp%20between%20'96'%20and%20'1000000'%20and%20y_sp%20between%20'120000'%20and%20'270000'
       // String query = "$select=spc_common&$where=x_sp%20between%20" +



        return null;
    }

    private static void getTreesForOffset(double x, double y, double raidusInMeters) {
        String requestUri = "";
    }
}
