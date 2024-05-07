package com.repositories;

import com.models.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository {
    public List<Data> getAll();
}
