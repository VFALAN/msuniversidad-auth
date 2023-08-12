package com.vf.dev.msuniversidadauth.service.usuario;

import com.vf.dev.msuniversidadauth.model.dto.generic.LoginDTO;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadauth.repository.IUsuarioRepository;
import com.vf.dev.msuniversidadauth.util.MsUniversidadException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCrypt;


    @Override
    public UsuarioEntity findById(Integer pId) throws MsUniversidadException {
        Optional<UsuarioEntity> optionalUsuarioEntity = this.iUsuarioRepository.findById(pId);
        if (optionalUsuarioEntity.isPresent()) {
            return optionalUsuarioEntity.get();
        } else {
            throw new MsUniversidadException("No Se Ha Encontrado Ningun Usuario Con El ID_USUARIO: " + pId, "E1001");
        }
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return null;
    }

    @Override
    public void delete(UsuarioEntity pEntitty) {
        pEntitty.setIndActivo(false);
        pEntitty.setFechaBaja(new Date());
        this.iUsuarioRepository.save(pEntitty);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity pEntity) {
        return null;
    }

    @Override
    public UsuarioEntity findByCorreoONombreUsuario(LoginDTO pLogin) throws MsUniversidadException {
        try {
            return this.iUsuarioRepository.findByCorreoNombreUsuario(pLogin.getUsername());

        } catch (NonUniqueResultException e) {
            log.info(e.getMessage());
            throw new MsUniversidadException("Se a encontrado mas de un usaurio con el correo o nombre de usuario : " + pLogin.getUsername(), "1002");
        }
    }
}
