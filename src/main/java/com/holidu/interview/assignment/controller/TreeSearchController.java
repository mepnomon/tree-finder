package com.holidu.interview.assignment.controller;

import com.holidu.interview.assignment.models.SearchParameters;
import com.holidu.interview.assignment.service.TreeSearchService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TreeSearchController {

    TreeSearchService treeSearchService;

    public TreeSearchController(TreeSearchService treeSearchService){
        this.treeSearchService = treeSearchService;
    }


    @GetMapping("/treeSearch")
    public ResponseEntity searchTrees(@RequestParam double x,
                                      @RequestParam double y,
                                      @RequestParam double radiusInMeters){


        SearchParameters searchParameters = new SearchParameters(x, y, radiusInMeters);
        Map<String, Integer> commonNames = treeSearchService.getTrees(searchParameters);

        JSONObject treeJson = new JSONObject();
        commonNames.entrySet().forEach(tree -> treeJson.put(tree.getKey(), tree.getValue()));

        return ResponseEntity.status(HttpStatus.OK).body(treeJson.toString());
    }
}
