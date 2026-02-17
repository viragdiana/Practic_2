package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Supply;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplyService {
    private List<Supply> supplies = new ArrayList<>();

    //AUFGABE 1 ----------------------------------------------------------------------------------------
    //Load Supplys from json file
    public void loadSupplys(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.supplies = mapper.readValue(new File(filepath), new TypeReference<List<Supply>>() {});
    }

    //Number of Supplys from file
    public int getNumberOfSupplys(){return supplies.size();}

    //Get all Supplys
    public List<Supply> getAlLSupplys(){return supplies;}



}
