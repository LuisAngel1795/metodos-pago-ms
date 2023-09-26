package com.ds.metodospago.metodospago.controller;

import com.ds.metodospago.metodospago.exceptions.DataNotFoundException;
import com.ds.metodospago.metodospago.exceptions.EntityOKException;
import com.ds.metodospago.metodospago.models.RespuestaObtenerMetodosPago;
import com.ds.metodospago.metodospago.services.IMetodosPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cd-microservice")
public class MetodosPagoController {
    @Autowired
    private IMetodosPagoService service;

    @GetMapping("/metodos-pago")
    @ResponseStatus(HttpStatus.OK)
    public List<RespuestaObtenerMetodosPago> metodosPago(){
        return service.obtnerMetodosPagos();
    }

}
