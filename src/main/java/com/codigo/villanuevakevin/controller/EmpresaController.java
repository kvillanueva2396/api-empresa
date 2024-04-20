package com.codigo.villanuevakevin.controller;

import com.codigo.villanuevakevin.entity.EmpresaEntity;
import com.codigo.villanuevakevin.request.EmpresaRequest;
import com.codigo.villanuevakevin.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE EMPRESA - EXAMEN",
        description = "API de examen con la tabla empresa"
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa creada correctamente",
            content = { @Content(mediaType = "application",
            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity.ok(empresaService.crear(empresaRequest));
    }

    @Operation(summary = "Buscar una Empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada",
                    content = { @Content(mediaType = "application",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @Operation(summary = "Buscar todas las empresas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresas encontradas",
                    content = { @Content(mediaType = "application",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarTodos() {
        return ResponseEntity.ok(empresaService.buscarTodos());
    }

    @Operation(summary = "Actualizar una Empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa actualizada correctamente",
                    content = { @Content(mediaType = "application",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity.ok(empresaService.actualizar(id, empresaRequest));
    }

    @Operation(summary = "Eliminar una Empresa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa eliminada correctamente",
                    content = { @Content(mediaType = "application",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}
