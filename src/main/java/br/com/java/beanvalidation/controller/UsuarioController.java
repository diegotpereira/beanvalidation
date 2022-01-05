package br.com.java.beanvalidation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.beanvalidation.entity.UsuarioEntity;
import br.com.java.beanvalidation.service.UsuarioService;

import org.springframework.http.HttpStatus;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    

    @PostMapping(path = "/salvar", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity criar(@Valid @RequestBody UsuarioEntity usuarioEntity) {
    	//log.debug("Iniciando o método");

        try {
            usuarioService.criar(usuarioEntity);

            return ResponseEntity.ok(usuarioEntity);

        } catch (Exception e) {
            
           // log.debug("Erro durante o salvamento do novo usuário.");

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
