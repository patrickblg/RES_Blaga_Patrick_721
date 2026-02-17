package org.example.repo;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InFileRepo<T> {

    private final String filename;
    private final Class<T[]> array;
    ObjectMapper mapper = new ObjectMapper();

    public InFileRepo(String filename, Class<T[]> array) {
        this.filename = filename;
        this.array = array;
    }
    public List<T> readAll(){
        return new ArrayList<>(Arrays.asList(mapper.readValue(new File(filename),array)));
    }
}
