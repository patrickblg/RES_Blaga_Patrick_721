package org.example.controller;

import org.example.model.Astronaut;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

import java.util.List;

public class Controller {
    private final AstronautService astronautService;
    private final MissionEventService missionEventService;
    private final SupplyService supplyService;

    public Controller(AstronautService astronautService, MissionEventService missionEventService, SupplyService supplyService) {
        this.astronautService = astronautService;
        this.missionEventService = missionEventService;
        this.supplyService = supplyService;
    }

    public void showCount(){
        System.out.println("Astronauts loaded: "+astronautService.findAll().size());
        System.out.println("Missions loaded: "+missionEventService.findAll().size());
        System.out.println("Supply loaded: "+supplyService.findAll().size());
    }

    public void showAllAstronauts(){
        List<Astronaut> astronauts = astronautService.findAll();
        astronauts.forEach(System.out::println);
    }
    public void showFiltereAstronauts(String spacecraft){
        astronautService.filterBySpacecraftAndStatus(spacecraft).forEach(System.out::println);

    }

    public void showSortAstronauts(){
        astronautService.sortByExpThenName().forEach(System.out::println);
    }
}
