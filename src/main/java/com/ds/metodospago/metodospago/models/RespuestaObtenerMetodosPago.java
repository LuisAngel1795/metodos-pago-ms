package com.ds.metodospago.metodospago.models;

public class RespuestaObtenerMetodosPago {
    private int id;
    private String descripcion;

    public RespuestaObtenerMetodosPago() {
    }

    public RespuestaObtenerMetodosPago(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
