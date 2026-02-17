package org.example.service;

import org.example.model.Supply;
import org.example.repo.InFileRepo;

import java.util.List;

public class SupplyService {

    private final InFileRepo<Supply> repo;
    public SupplyService(InFileRepo inFileRepo) {
        this.repo = inFileRepo;
    }

    public List<Supply> findAll() {
        return repo.readAll();
    }
}
