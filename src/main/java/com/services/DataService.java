package com.services;

import com.models.Data;
import com.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataService implements IService<Data> {
    @Autowired
    private IRepository<Data> iRepository;

    @Override
    public List<Data> getAll() {
       return iRepository.getAll();
    }

    @Override
    public int insertTable(Data data) {
        return iRepository.insertTable(data);
    }

}
