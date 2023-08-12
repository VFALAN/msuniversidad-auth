package com.vf.dev.msuniversidadauth.model.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class SubMenuResponseDTO implements Serializable {
    private String icon;
    private String nombre;
    private String path;
}
