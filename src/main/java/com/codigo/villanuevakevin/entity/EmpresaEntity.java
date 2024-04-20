package com.codigo.villanuevakevin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razon_social", length = 255)
    private String razonSocial;

    @Column(name = "tipo_documento", length = 1)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 11)
    private String numeroDocumento;

    @Column(name = "condicion", length = 10)
    private String condicion;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "distrito", length =  255)
    private String distrito;

    @Column(name = "provincia", length = 255)
    private String provincia;

    @Column(name = "departamento", length = 255)
    private String departarmento;

    @Column(name = "es_agente_retencion")
    private boolean esAgenteRetencion;

    @Column(name = "estado")
    private int estado;

    @Column(name = "usua_create", length = 50)
    private String usuaCreate;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "usua_modif")
    private String usuaModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    @Column(name = "usua_delet")
    private String usuaDelet;

    @Column(name = "date_delet")
    private Timestamp dateDelet;
}
