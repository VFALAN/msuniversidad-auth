package com.vf.dev.msuniversidadauth.controller.auth;

import com.vf.dev.msuniversidadauth.model.dto.generic.ApartadoResponseDTO;
import com.vf.dev.msuniversidadauth.model.dto.generic.MenuResponseDTO;
import com.vf.dev.msuniversidadauth.service.apartado.IApartadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuCotroller {
    @Autowired
    private IApartadoService iApartadoService;

    @GetMapping("/{idPerfil}")
    public ResponseEntity<List<ApartadoResponseDTO>> getMenu(@PathVariable("idPerfil") Integer idPerfil) throws Exception {
        var response = this.iApartadoService.findAllByPerfil(idPerfil);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
