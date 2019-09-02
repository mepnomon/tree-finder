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

            if(checkIfInsideCircle(obj, parameters)) {

                if (obj.has("spc_common")) {
                    commonNames = addTreeNameToMap(obj, commonNames);
                }
            }
        }
        return commonNames;
    }

    private boolean checkIfInsideCircle(JSONObject obj, SearchParameters params){

        if(obj.has("x_sp") && obj.has("y_sp")) {
            double x = obj.getDouble("x_sp");
            double y = obj.getDouble("y_sp");

            return circleTester.checkIfInsideCircle(params, x, y);
        }
        return false;
    }

    private Map<String, Integer> addTreeNameToMap(JSONObject obj, Map<String, Integer> commonNames){

        String treeName = obj.getString("spc_common");
         if (!commonNames.containsKey(treeName)) {
             commonNames.put(treeName, 1);
         } else {
             commonNames.put(treeName, commonNames.get(treeName) + 1);
         }
        return commonNames;
    }
}