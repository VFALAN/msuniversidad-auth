package com.vf.dev.msuniversidadauth.repository;

import com.vf.dev.msuniversidadauth.model.entity.PerfilApartadoEntity;
import com.vf.dev.msuniversidadauth.model.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilApartadoEntityRepository extends JpaRepository<PerfilApartadoEntity, Integer> {
    @Query("select pa from PerfilApartadoEntity pa where pa.idPerfil = :idPerfil")
    List<PerfilApartadoEntity> findAllByPerfil(@Param("idPerfil")PerfilEntity perfilEntity);
}