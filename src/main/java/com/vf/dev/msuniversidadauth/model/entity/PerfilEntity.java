package com.vf.dev.msuniversidadauth.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PERFILES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilEntity extends TableGeneric implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL")
    @Basic(optional = false)
    private Integer idPerfil;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "perfil")
    private List<UsuarioEntity> usuarios;

    @OneToMany(mappedBy = "idPerfil")
    private List<PerfilApartadoEntity> apartadoMenuEntities;


}
