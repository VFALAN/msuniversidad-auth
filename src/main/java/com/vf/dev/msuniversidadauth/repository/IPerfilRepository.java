package com.vf.dev.msuniversidadauth.repository;

import com.vf.dev.msuniversidadauth.model.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<PerfilEntity, Integer> {
}
