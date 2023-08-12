package com.vf.dev.msuniversidadauth.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SUB_MENUS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubMenuEntity  implements Serializable {
    @Id
    @Column(name = "ID_SUB_MENU")
    private Integer idSubMenu;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ICONO")
    private String icono;
    @Column(name = "PATH")
    private String path;
    @Column(name = "IND_ACTIVO")
    private Boolean indActivo;
    @JoinColumn(name = "ID_MENU")
    @ManyToOne
    private MenuEntity idMenu;
}
