package com.vf.dev.msuniversidadauth.model.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "APARTADOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApartadoMenuEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_APARTADO")
    private Integer idApartado;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ICON")
    private String icon;
    @Column(name = "HAS_MENU")
    private Boolean hasMenu;
    @Column(name = "PATH")
    private String path;

    @OneToMany(mappedBy = "idApartado" ,fetch = FetchType.EAGER)
    private List<MenuEntity> menuList;

    @OneToMany(mappedBy = "idApartadoMenu")
    private List<PerfilApartadoEntity> perfilApartadoEntities;


}
