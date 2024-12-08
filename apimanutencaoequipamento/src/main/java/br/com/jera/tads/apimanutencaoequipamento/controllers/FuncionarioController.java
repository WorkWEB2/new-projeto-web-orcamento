package br.com.jera.tads.apimanutencaoequipamento.controllers;

import br.com.jera.tads.apimanutencaoequipamento.commom.Response;
import br.com.jera.tads.apimanutencaoequipamento.exceptions.ValidationException;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioEditDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioFormDTO;
import br.com.jera.tads.apimanutencaoequipamento.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;

    @PostMapping("/registrar")
    @Operation(summary = "Registrar funcionario")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = FuncionarioDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros inv\u00E1lidos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "403", description = "Não Autorizado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "504", description = "Timeout", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }), })
    public ResponseEntity<FuncionarioDTO> register(@RequestBody @Valid FuncionarioFormDTO funcionarioDTO) throws ValidationException  {
        return ResponseEntity.ok().body(new FuncionarioDTO(service.save(funcionarioDTO)));
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar funcionario")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = FuncionarioDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros inv\u00E1lidos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "403", description = "Não Autorizado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "504", description = "Timeout", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }), })
    public ResponseEntity<FuncionarioDTO> alterar(@RequestBody @Valid FuncionarioEditDTO funcionarioDTO , @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new FuncionarioDTO(service.update(funcionarioDTO,id)));
    }

    @DeleteMapping("deletar/{id}")
    @Operation(summary = "Deletar funcionario")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros inv\u00E1lidos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "403", description = "Não Autorizado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "504", description = "Timeout", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }), })
    public ResponseEntity<Boolean> deletar(@PathVariable("id") Long id) throws ValidationException {
        return ResponseEntity.ok().body(service.delete(id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionario")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = FuncionarioDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros inv\u00E1lidos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "403", description = "Não Autorizado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "504", description = "Timeout", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }), })
    public ResponseEntity<FuncionarioDTO> buscar(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(new FuncionarioDTO(service.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Buscar funcionarios")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros inv\u00E1lidos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "403", description = "Não Autorizado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro Interno do Servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }),
            @ApiResponse(responseCode = "504", description = "Timeout", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)) }), })
    public ResponseEntity<List<FuncionarioDTO>> buscar() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
