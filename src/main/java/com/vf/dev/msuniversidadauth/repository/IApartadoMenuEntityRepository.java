package com.vf.dev.msuniversidadauth.repository;

import com.vf.dev.msuniversidadauth.model.entity.ApartadoMenuEntity;
import com.vf.dev.msuniversidadauth.model.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApartadoMenuEntityRepository extends JpaRepository<ApartadoMenuEntity, Integer> {
    @Query("select a from ApartadoMenuEntity a left join a.perfilApartadoEntities ap where ap.idPerfil = :idPerfil ")
    List<ApartadoMenuEntity> findApartadosByPerfil(@Param("idPerfil") PerfilEntity pPerfilEntity);
}