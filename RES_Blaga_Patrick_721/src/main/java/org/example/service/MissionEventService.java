package org.example.service;

import org.example.model.MissionEvent;
import org.example.repo.InFileRepo;

import java.util.List;

public class MissionEventService {

    private final InFileRepo<MissionEvent> repo;
    public MissionEventService(InFileRepo inFileRepo) {
        this.repo = inFileRepo;
    }

    public List<MissionEvent> findAll() {
        return repo.readAll();
    }
}
