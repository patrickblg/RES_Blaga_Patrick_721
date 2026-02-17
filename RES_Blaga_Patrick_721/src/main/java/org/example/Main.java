package org.example;


import org.example.controller.Controller;
import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.model.Supply;
import org.example.repo.InFileRepo;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

public class Main {
    static void main() {
        InFileRepo<Astronaut> astronautInFileRepo = new InFileRepo<>("C:\\Users\\blaga\\Desktop\\MAP\\RES_Blaga_Patrick_7211\\RES_Blaga_Patrick_721\\src\\main\\resources\\astronauts.json",Astronaut[].class);
        InFileRepo<MissionEvent> missionEventInFileRepo = new InFileRepo<>("C:\\Users\\blaga\\Desktop\\MAP\\RES_Blaga_Patrick_7211\\RES_Blaga_Patrick_721\\src\\main\\resources\\events.json",MissionEvent[].class);
        InFileRepo<Supply> supplyInFileRepo = new InFileRepo<>("C:\\Users\\blaga\\Desktop\\MAP\\RES_Blaga_Patrick_7211\\RES_Blaga_Patrick_721\\src\\main\\resources\\supplies.json",Supply[].class);

        AstronautService astronautService = new AstronautService(astronautInFileRepo);
        MissionEventService missionEventService = new MissionEventService(missionEventInFileRepo);
        SupplyService supplyService = new SupplyService(supplyInFileRepo);

        Controller controller = new  Controller(astronautService, missionEventService, supplyService);
        controller.showCount();
        controller.showAllAstronauts();
    }
}
