package com.services;

import com.models.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService {
    public List<Data> getAll();
}
