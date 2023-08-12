package com.vf.dev.msuniversidadauth.service.auth;

import com.vf.dev.msuniversidadauth.model.dto.generic.LoginDTO;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadauth.service.usuario.IUsuarioService;
import com.vf.dev.msuniversidadauth.util.MsUniversidadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class AuthentificationServiceImpl implements IAuthetificationService {
    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioEntity loadUserByUsername(LoginDTO loginDTO) throws UsernameNotFoundException, MsUniversidadException {
        UsuarioEntity usuario = this.iUsuarioService.findByCorreoONombreUsuario(loginDTO);

        if (this.passwordEncoder.matches(loginDTO.getPassword(), usuario.getPassword())) {
            return usuario;
        } else {
            throw new MsUniversidadException("Contraseña incorrecta", "111001");
        }

    }
}
