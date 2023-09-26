package com.ds.metodospago.metodospago.services;

import com.ds.metodospago.metodospago.models.RespuestaObtenerMetodosPago;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMetodosPagoService{
    public List<RespuestaObtenerMetodosPago> obtnerMetodosPagos();
}
