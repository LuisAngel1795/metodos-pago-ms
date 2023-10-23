package com.ds.metodospago.metodospago.exceptions;

public class JwtException extends RuntimeException{


    private static final long serialVersionUID = 6254269113946480791L;

    public JwtException(String message) {
        super(message);
    }
}
