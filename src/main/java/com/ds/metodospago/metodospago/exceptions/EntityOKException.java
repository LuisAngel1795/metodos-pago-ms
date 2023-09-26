package com.ds.metodospago.metodospago.exceptions;

public class EntityOKException extends  RuntimeException{
    public EntityOKException()  {
        super("Recurso creado con éxito.");
    }

    public EntityOKException(String message) {
        super(message);
    }

    public EntityOKException(String message, Throwable cause) {
        super(message, cause);
    }
}
