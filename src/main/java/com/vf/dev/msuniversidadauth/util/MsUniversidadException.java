package com.vf.dev.msuniversidadauth.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MsUniversidadException extends Exception {
    private String codigoInterno;

    public MsUniversidadException(String pMessage, String pCodigoInterno) {
        super(pMessage);
        this.setCodigoInterno(pCodigoInterno);
    }
}
