package com.holidu.interview.assignment.service;

import com.holidu.interview.assignment.models.SearchParameters;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TreeSearchService {

    private TreeAPIRequest treeAPIRequest;
    private CircleTester circleTester;


    public TreeSearchService(TreeAPIRequest treeAPIRequest, CircleTester circleTester) {
        this.treeAPIRequest = treeAPIRequest;
        this.circleTester = circleTester;
    }


    public Map<String, Integer> getTrees(SearchParameters parameters) {

        String result = treeAPIRequest.makeRequest(parameters);
        JSONArray jsonArray = new JSONArray(result);

        Map<String, Integer> commonNames = new HashMap<>();
        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject obj = jsonArray.getJSONObject(i);

            if(obj.has("x_sp") && obj.has("y_sp")) {
                double x = obj.getDouble("x_sp");
                double y = obj.getDouble("y_sp");

                if(circleTester.checkIfInsideCircle(parameters, x, y)) {

                    if (obj.has("spc_common")) {
                        String treeName = obj.getString("spc_common");
                        if (!commonNames.containsKey(treeName)) {
                            commonNames.put(treeName, 1);
                        } else {
                            commonNames.put(treeName, commonNames.get(treeName) + 1);
                        }
                    }
                }
            }
        }
        return commonNames;
    }
}