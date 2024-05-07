package com.services;

import com.models.Data;
import com.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataService implements IService{
    @Autowired
    private IRepository iRepository;

    @Override
    public List<Data> getAll() {
       return iRepository.getAll();
    }
}
