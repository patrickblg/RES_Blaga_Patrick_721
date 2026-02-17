package org.example.repo;

import tools.jackson.databind.ObjectMapper;

public class InFileRepo<T> {

    private final String filename;
    private final Class<T[]> array;
    ObjectMapper mapper = new ObjectMapper();
}
