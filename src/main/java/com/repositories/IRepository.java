package com.repositories;

import com.models.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository<T> {
    public List<T> getAll();
    public int insertTable(T t);
}
