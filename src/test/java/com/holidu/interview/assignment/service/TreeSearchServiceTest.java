package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TreeSearchServiceTest {

    TreeAPIRequest mockRequest = mock(TreeAPIRequest.class);
    CircleTester mockCircle = mock(CircleTester.class);

    // tree 2, another tree 1, binary tree 1, larch 1, oak tree 2
    String trees = "[" +
            "{\"spc_common\" : \"tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"another tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"binary tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"The larch\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"Oak Tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}," +
            "{\"spc_common\" : \"Oak Tree\", \"x_sp\" : \"5\", \"y_sp\" : \"5\"}" +
            "]";
    @Test
    public void count_occurrence_of_common_species_name_passes_if_results_match(){

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("tree", 2);
        expectedResult.put("Oak Tree", 2);
        expectedResult.put("binary tree", 1);
        expectedResult.put("another tree", 1);
        expectedResult.put("The larch", 1);

        SearchParameters searchParameters = new SearchParameters(5, 5, 10);
        TreeSearchService treeSearchService = new TreeSearchService(mockRequest, mockCircle);
        when(mockCircle.checkIfInsideCircle(searchParameters, 5,5)).thenReturn(true);
        when(mockRequest.makeRequest(searchParameters)).thenReturn(trees);

        Map<String, Integer> actualResult = treeSearchService.getTrees(searchParameters);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}