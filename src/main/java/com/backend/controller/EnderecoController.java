package com.backend.controller;



import com.backend.entity.Endereco;
import com.backend.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    @Operation(summary = "Endpoint para cadastro de endereco de pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereco cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),

    })
    public ResponseEntity<Endereco> save( @PathVariable(value = "idPessoa") Long idPessoa ,@RequestBody @Valid Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(idPessoa,endereco));
    }

    @GetMapping("/findEnderecoByPessoa/{idPessoa}")
    @Operation(summary = "Endpoint para buscar todos os enderecos de uma determinada pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registros encontrados"),
            @ApiResponse(responseCode = "404", description = "Não há registro")
    })
    public ResponseEntity<Set<Endereco>> findEnderecoByPessoa(@PathVariable("idPessoa") Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findEnderecoByPessoa(idPessoa));
    }


    @GetMapping("/{idEndereco}")
    @Operation(summary = "Endpoint para setar endereco principal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro atualizado"),
            @ApiResponse(responseCode = "404", description = "Endereco não existe"),
            @ApiResponse(responseCode = "400", description = "Falha ao atualizar")
    })
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Long idEndereco){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(idEndereco));
    }

}
