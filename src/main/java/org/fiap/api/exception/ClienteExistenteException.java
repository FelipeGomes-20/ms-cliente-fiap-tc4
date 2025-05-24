package org.fiap.api.exception;

import lombok.Getter;

@Getter
public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String message) {
        super(message);
    }
}
