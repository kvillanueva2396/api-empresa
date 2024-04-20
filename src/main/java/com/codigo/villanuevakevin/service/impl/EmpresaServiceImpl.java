package com.codigo.villanuevakevin.service.impl;

import com.codigo.villanuevakevin.dao.EmpresaRepository;
import com.codigo.villanuevakevin.entity.EmpresaEntity;
import com.codigo.villanuevakevin.request.EmpresaRequest;
import com.codigo.villanuevakevin.service.EmpresaService;
import com.codigo.villanuevakevin.utils.Constanst;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;
    @Override
    public EmpresaEntity crear(EmpresaRequest empresaRequest) {
        EmpresaEntity empresaEntity = getEmpresaCreate(empresaRequest);
        return empresaRepository.save(empresaEntity);
    }

    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    public EmpresaEntity getEmpresaCreate(EmpresaRequest empresaRequest) {
        EmpresaEntity entity = new EmpresaEntity();
        empresaMapper(empresaRequest, entity);
        entity.setEstado(Constanst.STATUS_ACTIVE);
        entity.setUsuaCreate(Constanst.USER);
        entity.setDateCreate(getTimestamp());
        return entity;
    }

    @Override
    public Optional<EmpresaEntity> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaRequest empresaRequest) {
        Optional<EmpresaEntity> empresa = empresaRepository.findById(id);

        if (empresa.isPresent()) {
            EmpresaEntity entity = empresa.get();
            empresaMapper(empresaRequest, entity);
            entity.setUsuaModif(Constanst.USER);
            entity.setDateModif(getTimestamp());
            return empresaRepository.save(entity);
        }
        return null;
    }

    private void empresaMapper(EmpresaRequest empresaRequest, EmpresaEntity entity) {
        entity.setRazonSocial(empresaRequest.getRazonSocial());
        entity.setTipoDocumento(empresaRequest.getTipoDocumento());
        entity.setNumeroDocumento(empresaRequest.getNumeroDocumento());
        entity.setCondicion(empresaRequest.getCondicion());
        entity.setDireccion(empresaRequest.getDireccion());
        entity.setDistrito(empresaRequest.getDistrito());
        entity.setProvincia(empresaRequest.getProvincia());
        entity.setDepartarmento(empresaRequest.getDepartarmento());
        entity.setEsAgenteRetencion(empresaRequest.isEsAgenteRetencion());
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresa = empresaRepository.findById(id);

        if (empresa.isPresent()) {
            empresa.get().setUsuaDelet(Constanst.USER);
            empresa.get().setDateDelet(getTimestamp());
            return empresaRepository.save(empresa.get());
        }
        return null;
    }
}
