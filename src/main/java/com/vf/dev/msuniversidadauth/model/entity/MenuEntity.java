package com.vf.dev.msuniversidadauth.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MENUS")
public class MenuEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MENU", nullable = false)
    private Integer idMenu;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ICON")
    private String icon;
    @Column(name = "PATH")
    private String path;

    @JoinColumn(name = "ID_APARTADO")
    @ManyToOne
    private ApartadoMenuEntity idApartado;


    @OneToMany(mappedBy = "idMenu", fetch = FetchType.EAGER)
    List<SubMenuEntity> subMenus;

}