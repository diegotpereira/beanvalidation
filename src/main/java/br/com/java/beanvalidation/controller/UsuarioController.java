package br.com.java.beanvalidation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.beanvalidation.entity.UsuarioEntity;
import br.com.java.beanvalidation.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    

    @PostMapping(path = "",produces = "application/json")
    public ResponseEntity criarNovoUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {

        log.debug("Iniciando Método.");

        try {
            usuarioService.criar( usuarioEntity );

            return ResponseEntity.ok(usuarioEntity);
        }catch (Exception ee) {
            log.debug("Erro durante o Salvamento do novo usuario.");
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }
}
