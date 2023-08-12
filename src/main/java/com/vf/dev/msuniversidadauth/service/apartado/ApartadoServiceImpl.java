package com.vf.dev.msuniversidadauth.service.apartado;

import com.vf.dev.msuniversidadauth.model.dto.generic.ApartadoResponseDTO;
import com.vf.dev.msuniversidadauth.model.entity.ApartadoMenuEntity;
import com.vf.dev.msuniversidadauth.model.entity.PerfilEntity;
import com.vf.dev.msuniversidadauth.repository.IApartadoMenuEntityRepository;
import com.vf.dev.msuniversidadauth.repository.IMenuEntityRepository;
import com.vf.dev.msuniversidadauth.repository.IPerfilRepository;
import com.vf.dev.msuniversidadauth.repository.PerfilApartadoEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ApartadoServiceImpl implements IApartadoService {
    @Autowired
    private IApartadoMenuEntityRepository iApartadoMenuEntityRepository;
    @Autowired
    private IPerfilRepository iPerfilRepository;
    @Autowired
    private IMenuEntityRepository iMenuEntityRepository;
    @Autowired
    private PerfilApartadoEntityRepository perfilApartadoEntityRepository;
    @Autowired
    private ModelMapper modelMaper;

    @Override
    public List<ApartadoResponseDTO> findAllByPerfil(Integer idPerfil) throws Exception {
        List<ApartadoResponseDTO> apartadoResponseDTOS = new ArrayList<>();

        Optional<PerfilEntity> optionalPerfilEntity = this.iPerfilRepository.findById(idPerfil);
        if (optionalPerfilEntity.isPresent()) {
            var apartadosList = this.findAllEntitisById(optionalPerfilEntity.get());

            apartadosList.forEach(apartadoMenuEntity -> {
                var objectMapped = this.modelMaper.map(apartadoMenuEntity, ApartadoResponseDTO.class);
                apartadoResponseDTOS.add(objectMapped);

            });
        } else {
            throw new Exception("No se encontro ningun Perfil con el id: " + idPerfil);
        }
        return apartadoResponseDTOS;
    }


    private List<ApartadoMenuEntity> findAllEntitisById(PerfilEntity pPerfilEntity) {
        return this.iApartadoMenuEntityRepository.findApartadosByPerfil(pPerfilEntity);
    }
}
