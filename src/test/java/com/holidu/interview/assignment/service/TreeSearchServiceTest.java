package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TreeSearchServiceTest {

    TreeAPIRequest mockRequest = mock(TreeAPIRequest.class);

    // tree 2, another tree 1, binary tree 1, larch 1, oak tree 2
    String trees = "[" +
            "{\"spc_common\" : \"tree\"}," +
            "{\"spc_common\" : \"another tree\"}," +
            "{\"spc_common\" : \"tree\"}," +
            "{\"spc_common\" : \"binary tree\"}," +
            "{\"spc_common\" : \"The larch\"}," +
            "{\"spc_common\" : \"Oak Tree\"}," +
            "{\"spc_common\" : \"Oak Tree\"}" +
            "]";
    @Test
    public void count_occurrence_of_common_species_name_passes_if_results_match(){

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("tree", 2);
        expectedResult.put("Oak Tree", 2);
        expectedResult.put("binary tree", 1);
        expectedResult.put("another tree", 1);
        expectedResult.put("The larch", 1);

        SearchParameters searchParameters = new SearchParameters(1, 2, 10);
        TreeSearchService treeSearchService = new TreeSearchService(mockRequest);
        when(mockRequest.makeRequest(searchParameters)).thenReturn(trees);

        Map<String, Integer> actualResult = treeSearchService.getTrees(searchParameters);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}