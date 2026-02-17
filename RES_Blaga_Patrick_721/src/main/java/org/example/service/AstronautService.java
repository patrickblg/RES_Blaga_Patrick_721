package org.example.service;

import org.example.model.Astronaut;
import org.example.repo.InFileRepo;

import java.util.List;

public class AstronautService {

    private final InFileRepo<Astronaut> repo;
    public AstronautService(InFileRepo inFileRepo) {
        this.repo = inFileRepo;
    }

    public List<Astronaut> findAll() {
        return repo.readAll();
    }
}
