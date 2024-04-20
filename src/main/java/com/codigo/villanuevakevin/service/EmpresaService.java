package com.codigo.villanuevakevin.service;

import com.codigo.villanuevakevin.entity.EmpresaEntity;
import com.codigo.villanuevakevin.request.EmpresaRequest;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaEntity crear(EmpresaRequest empresaRequest);
    Optional<EmpresaEntity> buscarPorId(Long id);
    List<EmpresaEntity> buscarTodos();
    EmpresaEntity actualizar(Long id, EmpresaRequest empresaRequest);
    EmpresaEntity borrar(Long id);
}
