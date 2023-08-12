package com.vf.dev.msuniversidadauth.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
@Getter
@Setter
public abstract class TableGeneric {
    @Column(name="FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    @Column(name = "FECHA_BAJA")
    private Date fechaBaja;
    @Column(name = "FECHA_ALTA")
    private Date fechaAlta;
    @Column(name = "IND_ACTIVO")
    private boolean indActivo;

}
