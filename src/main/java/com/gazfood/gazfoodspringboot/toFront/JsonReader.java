package com.gazfood.gazfoodspringboot.toFront;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazfood.gazfoodspringboot.entity.Orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    public List<Orders> getOrders(String json){
        ObjectMapper mapper = new ObjectMapper();
        List<Orders> methodList = new ArrayList<>();
        try {
            methodList = Arrays.asList(mapper.readValue(json,Orders[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return methodList;
    }
}
