package org.example.controller;

import org.example.model.Supply;
import org.example.service.SupplyService;

import java.io.IOException;
import java.util.List;

public class SupplyController {
    private SupplyService service;

    public SupplyController(SupplyService service){
        this.service = service;
    }
    //AUFGABE  1 --------------------------------------------------------------------------------
    public void loadSupplys(String filepath) throws IOException {
        service.loadSupplys(filepath);
    }

    //Number of Supplys from file
    public int getNumberOfSupplys(){return service.getNumberOfSupplys();}

    //Get all Supplys
    public List<Supply> getAlLSupplys(){return service.getAlLSupplys();}



}
