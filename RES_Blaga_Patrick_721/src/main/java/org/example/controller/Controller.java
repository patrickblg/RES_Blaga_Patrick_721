package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.model.MissionEventType;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

import java.util.*;

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
    public void writeToTxt(){
        astronautService.writeSorted("C:\\Users\\blaga\\Desktop\\MAP\\RES_Blaga_Patrick_7211\\RES_Blaga_Patrick_721\\src\\main\\resources\\astronauts_sorted.txt");
    }

    public void showTop5Events(){
        List<MissionEvent> missionEvents = missionEventService.findAll();
        missionEvents.stream().limit(5)
                .forEach(m->System.out.println("Event <"+m.getId()+"> -> raw=<"+ m.getBasePoints()+"> -> computed=<"+ missionEventService.computePoints(m)+">"));
    }

    public void totalScore(){
        List<Astronaut> astronauts = astronautService.findAll();
        for(Astronaut a:astronauts){
            a.setTotalScore(missionEventService.sumComputedPoints(a)+supplyService.supplySum(a));
        }
        astronauts.stream()
                .sorted(Comparator.comparingInt(Astronaut::getTotalScore).reversed().thenComparing(Comparator.comparing(Astronaut::getName)))
                .limit(5)
                .forEach(a-> System.out.println(a.getName() + "("+ a.getSpacecraft()+ ") ->"+ a.getTotalScore()));
    }
    public void getLeadingSpacecraft(){
        List<Astronaut> astronauts = astronautService.findAll();
        for(Astronaut a:astronauts){
            a.setTotalScore(missionEventService.sumComputedPoints(a)+supplyService.supplySum(a));
        }
        List<Astronaut> result= new ArrayList<>();
        result = astronauts.stream().sorted(Comparator.comparingInt(Astronaut::getTotalScore).reversed().thenComparing(Comparator.comparing(Astronaut::getName)))
                .toList();

        System.out.println(result.get(0).getSpacecraft());
    }

    public void writeMap(){
        String content="";
        Map<MissionEventType, Integer> map = missionEventService.resultMap();
        for(Map.Entry<MissionEventType, Integer> e:map.entrySet()){
            content+=e.getKey() + "->" +e.getValue()+"\n";
        }
        missionEventService.writeToTxt(content);

    }

}
