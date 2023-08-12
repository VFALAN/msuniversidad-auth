package com.vf.dev.msuniversidadauth.controller.auth;

import com.vf.dev.msuniversidadauth.model.dto.generic.LoginDTO;
import com.vf.dev.msuniversidadauth.model.dto.generic.ResponseObject;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadauth.service.auth.AuthentificationServiceImpl;
import com.vf.dev.msuniversidadauth.util.jwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentification/")
@Slf4j
@CrossOrigin(origins = "*")
public class AutentificationController {

    @Autowired
    private AuthentificationServiceImpl authentificationService;
    @Autowired
    private  jwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("login")
    public ResponseEntity<String> autentificarse(@RequestBody LoginDTO loginDTO) {
        try {
            log.info(passwordEncoder.encode(loginDTO.getPassword()));
            UsuarioEntity details = this.authentificationService.loadUserByUsername(loginDTO);
            String token = this.jwtUtil.addAuthentification(details);
            return new ResponseEntity<String>(token, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<String>("algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
