package com.vf.dev.msuniversidadauth.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PEFILES_APARTADOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilApartadoEntity implements Serializable {

    @Id
    @Column(name = "ID_PERFIL_APARTADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfilApartado;

    @JoinColumn(name = "ID_PERFIL")
    @ManyToOne
    private PerfilEntity idPerfil;

    @JoinColumn(name = "ID_APARTADO")
    @ManyToOne
    private ApartadoMenuEntity idApartadoMenu;

}
