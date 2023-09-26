package com.ds.metodospago.metodospago.dao;

import com.ds.metodospago.metodospago.models.MetodosPago;
import org.springframework.data.repository.CrudRepository;

public interface IDao extends CrudRepository<MetodosPago, Integer> {
}
