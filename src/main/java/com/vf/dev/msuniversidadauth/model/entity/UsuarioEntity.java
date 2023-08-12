package com.vf.dev.msuniversidadauth.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USUARIOS")
@Data
public class UsuarioEntity extends TableGeneric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "FOLIO")
    private String folio;
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "CURP")
    private String curp;
    @Column(name = "DES_GENERO")
    private String desGenero;
    @Column(name = "GENERO")
    private int genero;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @JoinColumn(name = "ID_PERFIL")
    @ManyToOne
    private PerfilEntity perfil;
    @JoinColumn(name="ID_ESTATUS")
    @ManyToOne
    private EstatusEntity estatus;


}
