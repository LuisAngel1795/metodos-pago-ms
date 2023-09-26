package com.ds.metodospago.metodospago.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


public class RespuestaExcepcionesDto {

    private String codigo;
    private String mensaje;
    private String folio;
    private String info;
    private List<Object> detalles;

    public RespuestaExcepcionesDto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Object> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Object> detalles) {
        this.detalles = detalles;
    }
}
