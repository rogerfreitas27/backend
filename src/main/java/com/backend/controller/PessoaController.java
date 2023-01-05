package com.backend.controller;


import com.backend.entity.Pessoa;
import com.backend.service.PessoaService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @Operation(summary = "Endpoint para cadastro de pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),

    })
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));

    }

    @PutMapping
    @Operation(summary = "Endpoint para atualizar cadastro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro atualizado com sucesso ")

    })
    public ResponseEntity<Pessoa> update(@Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoa));
    }




    @GetMapping
    @Operation(summary = "Endpoint para buscar todas as pessoas, a api devolve a lista de pessoas "
            + "paginada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar todas as pessoas"),
            @ApiResponse(responseCode = "404", description = "Não há registro de pessoas")
    })
    public ResponseEntity<Page<Pessoa>> findAll(@PageableDefault(size=5) Pageable peageable){
        return  ResponseEntity.ok(pessoaService.findAll(peageable));
    }
}
