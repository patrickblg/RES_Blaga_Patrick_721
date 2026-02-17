package org.example.service;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.model.MissionEventType;
import org.example.repo.InFileRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionEventService {

    private final InFileRepo<MissionEvent> repo;
    public MissionEventService(InFileRepo inFileRepo) {
        this.repo = inFileRepo;
    }

    public List<MissionEvent> findAll() {
        return repo.readAll();
    }

    public int computePoints(MissionEvent m){
        int computed=0;
        switch (m.getType()){
            case EVA-> computed = m.getBasePoints() +2 *m.getDay();
            case SYSTEM_FAILURE -> computed = m.getBasePoints() - 3 - m.getDay();
            case SCIENCE -> computed =  m.getBasePoints() + (m.getDay()%4);
            case MEDICAL -> computed = m.getBasePoints()-2*(m.getDay()%3);
            case COMMUNICATION -> computed = m.getBasePoints()+5;
            default -> computed = m.getBasePoints();
        }
        return computed;
    }
    //sum all computed points

    public int sumComputedPoints(Astronaut a){
        List<MissionEvent> missionEvents = findAll();
        int sum=0;
        for (MissionEvent missionEvent : missionEvents) {
            if(missionEvent.getAstronautId()==a.getId()){
                sum+=computePoints(missionEvent);
            }
        }
        return sum;
    }
    public Map<MissionEventType,Integer> resultMap(){
        Map<MissionEventType,Integer> result=new HashMap<>();
        List<MissionEvent> missionEvents = findAll();
        for (MissionEvent missionEvent : missionEvents) {
            if(result.containsKey(missionEvent.getType())){
                result.put(missionEvent.getType(),result.get(missionEvent.getType())+1);
            }else{
                result.put(missionEvent.getType(),1);
            }
        }
        return result;
    }

    public void writeToTxt(String content){
        repo.writeToTxt(content,"C:\\Users\\blaga\\Desktop\\MAP\\RES_Blaga_Patrick_7211\\RES_Blaga_Patrick_721\\src\\main\\resources\\mission_report.txt");
    }
}
