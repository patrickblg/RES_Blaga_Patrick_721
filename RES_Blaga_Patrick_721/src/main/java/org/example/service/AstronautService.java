package org.example.service;

import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.repo.InFileRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AstronautService {

    private final InFileRepo<Astronaut> repo;
    public AstronautService(InFileRepo inFileRepo) {
        this.repo = inFileRepo;
    }

    public List<Astronaut> findAll() {
        return repo.readAll();
    }
    public List<Astronaut> filterBySpacecraftAndStatus(String spacecraft) {
        List<Astronaut> astronauts = findAll();
        return astronauts.stream()
                .filter(a->a.getSpacecraft().equals(spacecraft)&&a.getStatus().equals(AstronautStatus.ACTIVE))
                .toList();
    }

    public List<Astronaut> sortByExpThenName() {
        List<Astronaut> astronauts = findAll();
        return astronauts.stream()
                .sorted(Comparator.comparingInt(Astronaut::getExperienceLevel).reversed().thenComparing(Comparator.comparing(Astronaut::getName)))
                .toList();
    }
}
