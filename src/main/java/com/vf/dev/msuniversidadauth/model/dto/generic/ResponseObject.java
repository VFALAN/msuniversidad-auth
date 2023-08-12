package com.vf.dev.msuniversidadauth.model.dto.generic;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject<T> implements Serializable {

    private String message = "";
    private Boolean error = false;
    private T data = null;
}
