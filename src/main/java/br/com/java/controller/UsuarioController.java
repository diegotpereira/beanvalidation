package br.com.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.entity.UsuarioEntity;
import br.com.java.service.UsuarioService;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

@RestController
// @RequestMapping("api/usuario")
@RequestMapping("api/v1")
@Slf4j
public class UsuarioController {
    
    // @Autowired(required=true)
    UsuarioService usuarioService;
    

    @PostMapping("/salvar")
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
