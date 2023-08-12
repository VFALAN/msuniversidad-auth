package com.vf.dev.msuniversidadauth.service.generic;

import com.vf.dev.msuniversidadauth.util.MsUniversidadException;

import java.util.List;

public interface IGenericService<T> {
    T findById(Integer pId) throws MsUniversidadException;

    List<T> findAll();

    void delete (T pEntitty);

    T update ( T pEntity);


}
