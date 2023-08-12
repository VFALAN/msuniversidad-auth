package com.vf.dev.msuniversidadauth.service.auth;

import com.vf.dev.msuniversidadauth.model.dto.generic.LoginDTO;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadauth.util.MsUniversidadException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IAuthetificationService {
    UsuarioEntity loadUserByUsername(LoginDTO loginDTO) throws UsernameNotFoundException, MsUniversidadException;
}
