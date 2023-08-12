package com.vf.dev.msuniversidadauth.repository;

import com.vf.dev.msuniversidadauth.model.entity.ApartadoMenuEntity;
import com.vf.dev.msuniversidadauth.model.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuEntityRepository extends JpaRepository<MenuEntity, Integer> {
    @Query("select m from MenuEntity m where m.idApartado = :idApartado")
    List<MenuEntity> findAllByApartado(@Param("idApartado")ApartadoMenuEntity apartadoMenuEntity);
}