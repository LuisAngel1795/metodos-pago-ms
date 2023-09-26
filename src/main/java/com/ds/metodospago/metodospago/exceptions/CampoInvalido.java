package com.ds.metodospago.metodospago.exceptions;

public class CampoInvalido extends RuntimeException{


    public CampoInvalido(String nombre, String valor){
        super(String.format("El campo %s, tiene un valor inválido: %s",nombre, valor ));
    }
}
