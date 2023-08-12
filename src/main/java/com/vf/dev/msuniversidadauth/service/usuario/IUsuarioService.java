package com.vf.dev.msuniversidadauth.service.usuario;

import com.vf.dev.msuniversidadauth.model.dto.generic.LoginDTO;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadauth.service.generic.IGenericService;
import com.vf.dev.msuniversidadauth.util.MsUniversidadException;

public interface IUsuarioService extends IGenericService<UsuarioEntity> {

    UsuarioEntity findByCorreoONombreUsuario(LoginDTO pLogin) throws MsUniversidadException;


}
