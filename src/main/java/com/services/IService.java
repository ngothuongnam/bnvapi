package com.services;

import com.models.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T> {
    public List<T> getAll();
    public int insertTable(T t);
}
