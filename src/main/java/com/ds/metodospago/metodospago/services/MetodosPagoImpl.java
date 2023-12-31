package com.ds.metodospago.metodospago.services;

import com.ds.metodospago.metodospago.dao.IDao;
import com.ds.metodospago.metodospago.exceptions.MetodosPagoException;
import com.ds.metodospago.metodospago.models.RespuestaObtenerMetodosPago;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class MetodosPagoImpl implements IMetodosPagoService{
    @Autowired
    private IDao dao;
    @Override
    public List<RespuestaObtenerMetodosPago> obtnerMetodosPagos() {
        List<RespuestaObtenerMetodosPago> lista = new ArrayList<RespuestaObtenerMetodosPago>();
        try{
            lista = StreamSupport.stream(dao.findAll().spliterator(),false).collect(Collectors.toList()).stream().map(
                    item -> new RespuestaObtenerMetodosPago(item.getId(),item.getDescripcion())
            ).collect(Collectors.toList());
            log.info("todo chido");
        }catch(Exception e){
            throw new MetodosPagoException(e.getMessage());
        }
        return  lista;
    }
}
