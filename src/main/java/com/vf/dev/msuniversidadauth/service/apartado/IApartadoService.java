package com.vf.dev.msuniversidadauth.service.apartado;

import com.vf.dev.msuniversidadauth.model.dto.generic.ApartadoResponseDTO;

import java.util.List;

public interface IApartadoService {
    List<ApartadoResponseDTO> findAllByPerfil(Integer idPerfil) throws Exception;
}
