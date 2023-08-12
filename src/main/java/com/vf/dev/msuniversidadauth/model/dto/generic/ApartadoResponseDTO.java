package com.vf.dev.msuniversidadauth.model.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartadoResponseDTO implements Serializable {
    private String nombre;
    private String icon;
    private Boolean hasMenu;
    private String path;
    private List<MenuResponseDTO> menuList;
}
