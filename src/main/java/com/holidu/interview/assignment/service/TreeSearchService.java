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
    //Gr
    public TreeSearchService(TreeAPIRequest treeAPIRequest, CircleTester circleTester) {
        this.treeAPIRequest = treeAPIRequest;
        this.circleTester = circleTester;
    }


    public Map<String, Integer> getTrees(SearchParameters parameters) {

        String result = treeAPIRequest.makeRequest(parameters);
        JSONArray jsonArray = new JSONArray(result);


        Map<String, Integer> commonNames = new HashMap<>();
        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject o = jsonArray.getJSONObject(i);

            if(o.has("x_sp") && o.has("y_sp")) {
                double x = o.getDouble("x_sp");
                double y = o.getDouble("y_sp");

                if(circleTester.checkIfInsideCircle(parameters, x, y)) {

                    if (o.has("spc_common")) {
                        o.getString("spc_common");
                        String treeName = o.getString("spc_common");
                        if (!commonNames.containsKey(treeName)) {
                            commonNames.put(treeName, 1);
                        } else {
                            Integer count = commonNames.get(treeName);
                            commonNames.put(treeName, count + 1);
                        }
                    }
                }
            }
        }
        return commonNames;
    }

}
