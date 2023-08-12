package com.vf.dev.msuniversidadauth.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Entity(name = "ESTATUS")
@Getter
@Setter
public class EstatusEntity extends TableGeneric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTATUS")
    private Integer idEstatus;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "NOMBRE")
    private String nombre;


    @OneToMany(mappedBy = "estatus")

    private List<UsuarioEntity> usuarios;


}
