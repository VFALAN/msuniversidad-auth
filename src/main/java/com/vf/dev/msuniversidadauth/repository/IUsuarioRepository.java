package com.vf.dev.msuniversidadauth.repository;

import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository  extends JpaRepository<UsuarioEntity  , Integer> {

    @Query("select u from UsuarioEntity u where u.correo = :username or u.nombreUsuario =:username")
    UsuarioEntity findByCorreoNombreUsuario(@Param("username") String username);
}
