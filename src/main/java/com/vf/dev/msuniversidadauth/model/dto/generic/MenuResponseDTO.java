package com.vf.dev.msuniversidadauth.model.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor

public class MenuResponseDTO implements Serializable {
private String icon;
private String nombre;
private String path;
private Boolean hasSubMenu;
private List<SubMenuResponseDTO> subMenus;
}
